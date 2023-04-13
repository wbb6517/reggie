package com.ourslook.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ourslook.reggie.common.R;
import com.ourslook.reggie.entity.Employee;
import com.ourslook.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * ClassName: EmployeeController
 * Package: com.ourslook.reggie.controller
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/10 16:27
 * @Version 1.0
 */


@Slf4j
@RestController
/**
 * @RestController 是 Spring 框架中的注解，它结合了 @Controller 和 @ResponseBody 注解的功能，用于创建 RESTful 风格的控制器（Controller）类。
 * @Controller 注解表示该类是一个控制器（Controller）类，Spring 会将其注册为一个 Bean。
 * @ResponseBody 注解表示将控制器方法返回的对象直接转换为 HTTP 响应消息的 body 部分，通常用于处理 AJAX 请求或者返回 JSON 格式的数据。
 * 因此，@RestController 注解可以直接将方法返回值转换为 JSON 或 XML 形式，方便前后端数据的传递。
 */
@RequestMapping("/employee")
/**
 * 该注解表示将 HTTP 请求映射到处理程序类或处理程序方法上，其中 "/employee" 是映射的 URL。
 * 当客户端发送到该 URL 的请求时，该注解告诉 Spring 将请求转发到使用此注解的处理程序类或方法。
 */
public class EmployeeController {
    @Autowired
    /**
     * @Autowired 是Spring框架中的注解，用于自动装配Bean，简化Bean的创建和依赖注入。
     * 使用@Autowired注解的变量、方法或构造函数参数，Spring容器会自动将匹配的Bean实例注入其中。
     * 通过使用@Autowired，可以避免手动编写大量的代码去实例化对象，减少了重复工作，提高了代码的简洁性和可读性。
     */
    private EmployeeService employeeService;


    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        /**
         * @RequestBody 注解通常用于 Spring MVC 控制器方法的参数上，用于指示方法参数应该从请求体中读取，而不是从请求 URL 参数中读取。
         *
         * 具体来说，当使用 @RequestBody 注解时，Spring 会将请求体中的内容读取为指定的对象类型，并将其作为控制器方法的参数传递给该方法。
         */

        //1、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(emp == null){
            return R.error("登录失败，不存在该用户！");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
            return R.error("登录失败，密码不正确！");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(emp.getStatus() == 0){
            return R.error("登录失败，账号已被冻结！");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);

    }

    /**
     * 员工退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前登录员工的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }


    /**
     * 新增员工
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("新增员工，员工信息：{}",employee.toString());

        //设置初始密码123456，需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
//        Long empId = (Long) request.getSession().getAttribute("employee");

//        employee.setCreateUser(empId);
//        employee.setUpdateUser(empId);

        employeeService.save(employee);

        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //执行查询
        employeeService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info(employee.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);

//        Long empId = (Long)request.getSession().getAttribute("employee");
//        employee.setUpdateTime(LocalDateTime.now());
//        employee.setUpdateUser(empId);
        employeeService.updateById(employee);

        return R.success("员工信息修改成功");
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Employee employee = employeeService.getById(id);
        if(employee != null){
            return R.success(employee);
        }
        return R.error("没有查询到对应员工信息");
    }

}
