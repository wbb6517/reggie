package com.ourslook.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ourslook.reggie.entity.Category;

/**
 * ClassName: CategoryService
 * Package: com.ourslook.reggie.service
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 15:50
 * @Version 1.0
 */
public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
