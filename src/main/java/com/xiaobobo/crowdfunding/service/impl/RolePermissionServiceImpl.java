package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.RolePermissionMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.RolePermission;
import com.xiaobobo.crowdfunding.service.RolePermissionService;


@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {


}