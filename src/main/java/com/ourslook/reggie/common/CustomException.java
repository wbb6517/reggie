package com.ourslook.reggie.common;

/**
 * ClassName: CustomException
 * Package: com.ourslook.reggie.common
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 16:35
 * @Version 1.0
 */

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
