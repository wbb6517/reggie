package com.ourslook.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ourslook.reggie.entity.Employee;
import com.ourslook.reggie.mapper.EmployeeMapper;
import com.ourslook.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * ClassName: EmployeeServiceImpl
 * Package: com.ourslook.reggie.service.impl
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/10 16:21
 * @Version 1.0
 */
@Service
/**
 * @Service 注解是Spring框架中的注解之一，用于标识一个类是服务层（Service），通常用于定义业务逻辑实现的类。
 * 在Spring中，通过注入Service类的实例对象来调用其中定义的方法，完成相应的业务逻辑处理。
 * 使用@Service注解可以让Spring框架自动扫描并注册该类的实例对象，简化了开发流程。
 */
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}

