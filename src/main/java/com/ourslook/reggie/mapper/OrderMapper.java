package com.ourslook.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ourslook.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.ourslook.reggie.mapper
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/13 21:30
 * @Version 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}
