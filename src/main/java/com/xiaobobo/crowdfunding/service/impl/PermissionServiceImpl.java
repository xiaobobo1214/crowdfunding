package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.PermissionMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Permission;
import com.xiaobobo.crowdfunding.service.PermissionService;


@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {


}