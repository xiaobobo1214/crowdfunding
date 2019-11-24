package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.UserMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.User;
import com.xiaobobo.crowdfunding.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}