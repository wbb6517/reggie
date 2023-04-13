package com.ourslook.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ourslook.reggie.entity.Orders;

/**
 * ClassName: OrderService
 * Package: com.ourslook.reggie.service
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/13 21:28
 * @Version 1.0
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
