package com.ourslook.reggie.entity.dto;


import com.ourslook.reggie.entity.OrderDetail;
import com.ourslook.reggie.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
