package com.ourslook.reggie.entity.dto;

import com.ourslook.reggie.entity.Setmeal;
import com.ourslook.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
