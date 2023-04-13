package com.ourslook.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.ourslook.reggie.common
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/11 15:26
 * @Version 1.0
 */


@ControllerAdvice(annotations = {RestController.class, Controller.class})
/**
 * @ControllerAdvice 注解用于定义全局控制器增强器，它可以对所有的 @RequestMapping 方法进行拦截。
 * 这个注解也可以指定需要拦截的注解，例如这里的 @RestController 和 @Controller。
 *
 * 使用 @ControllerAdvice 注解，可以定义一个全局的异常处理器，用于处理 Controller 层抛出的异常。
 * 通常情况下，我们可以在这里定义一些通用的异常处理逻辑，例如记录日志、返回错误信息等。
 */
@ResponseBody
/**
 * @ResponseBody 注解通常用于 Spring MVC 中的控制器方法上，
 * 表示将该方法的返回值直接作为 HTTP 响应体返回给客户端，
 * 而不是解析为视图进行渲染。该注解可以用于返回 JSON、XML 等格式的数据。
 */
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    /**
     * @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
     * 用于定义一个方法，用于捕获处理SQLIntegrityConstraintViolationException异常，
     * 该异常通常是由于违反数据库完整性约束引起的。
     */
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在";
            return R.error(msg);
        }

        return R.error("未知错误");
    }


    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
    }

}
