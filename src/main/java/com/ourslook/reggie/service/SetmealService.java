package com.ourslook.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ourslook.reggie.entity.Setmeal;
import com.ourslook.reggie.entity.dto.SetmealDto;

import java.util.List;

/**
 * ClassName: SetmealService
 * Package: com.ourslook.reggie.service
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 16:22
 * @Version 1.0
 */
public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
