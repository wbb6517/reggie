package com.ourslook.reggie.controller;

/**
 * ClassName: OrderDetailController
 * Package: com.ourslook.reggie.controller
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/13 21:32
 * @Version 1.0
 */

import com.ourslook.reggie.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单明细
 */
@Slf4j
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

}
