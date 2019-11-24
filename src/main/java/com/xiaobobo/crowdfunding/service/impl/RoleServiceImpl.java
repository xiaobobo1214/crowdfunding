package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.RoleMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Role;
import com.xiaobobo.crowdfunding.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


}