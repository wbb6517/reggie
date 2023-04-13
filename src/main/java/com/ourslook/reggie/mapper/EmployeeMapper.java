package com.ourslook.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ourslook.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: EmployeeMapper
 * Package: com.ourslook.reggie.mapper
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/10 16:14
 * @Version 1.0
 */
@Mapper
/**
 * 在MyBatis Plus中，@Mapper注解用于标识MyBatis的Mapper接口，
 * 它会被自动扫描并注入到Spring容器中，方便在Service中进行调用。
 * 同时，MyBatis Plus提供了自动的Mapper接口实现，无需手写XML文件即可进行CRUD操作。
 *
 * 需要注意的是，在使用MyBatis Plus时，@Mapper注解需要与@MapperScan注解一起使用。
 * @MapperScan 注解用于指定Mapper接口所在的包路径，
 * MyBatis Plus会自动扫描该路径下的所有Mapper接口并注入到Spring容器中。
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

}

