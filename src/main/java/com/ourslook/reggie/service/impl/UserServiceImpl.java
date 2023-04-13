package com.ourslook.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ourslook.reggie.entity.User;
import com.ourslook.reggie.mapper.UserMapper;
import com.ourslook.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.ourslook.reggie.service.impl
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/13 15:40
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
