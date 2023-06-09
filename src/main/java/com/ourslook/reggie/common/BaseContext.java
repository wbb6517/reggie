package com.ourslook.reggie.common;

/**
 * ClassName: BaseContext
 * Package: com.ourslook.reggie.common
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 15:01
 * @Version 1.0
 */
/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
