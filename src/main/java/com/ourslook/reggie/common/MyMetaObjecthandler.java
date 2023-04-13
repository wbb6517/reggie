package com.ourslook.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * ClassName: MyMetaObjecthandler
 * Package: com.ourslook.reggie.common
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 14:35
 * @Version 1.0
 */

/**
 * 自定义元数据对象处理器
 */
@Component
/**
 * @Component 是 Spring 框架中用于声明 bean 的注解，被注解的类会被 Spring 扫描到，并交给 Spring 管理。
 * 它是一个泛化的概念，作用于任何类上，而 @Service、@Repository、@Controller 等注解则是用来定义具体的类的作用的注解。
 * 通常我们将 @Component 注解用在那些比较中立的类上，如工具类等，而将 @Service、@Repository、@Controller 注解用在具有特定功能的类上。
 */
@Slf4j
public class MyMetaObjecthandler implements MetaObjectHandler {
    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());

        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }

    /**
     * 更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);

        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
