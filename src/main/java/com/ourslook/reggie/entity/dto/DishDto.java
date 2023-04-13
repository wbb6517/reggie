package com.ourslook.reggie.entity.dto;

import com.ourslook.reggie.entity.Dish;
import com.ourslook.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DishDto
 * Package: com.ourslook.reggie.dto
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 21:22
 * @Version 1.0
 */
@Data
public class DishDto extends Dish {

    //菜品对应的口味数据
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
