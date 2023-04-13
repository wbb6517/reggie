package com.ourslook.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ourslook.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Package: com.ourslook.reggie.mapper
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/13 15:39
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
