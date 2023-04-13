package com.ourslook.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ourslook.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: CategoryMapper
 * Package: com.ourslook.reggie.mapper
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/12 15:48
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
