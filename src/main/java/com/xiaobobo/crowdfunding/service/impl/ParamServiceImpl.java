package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.ParamDao;
import com.xiaobobo.crowdfunding.entity.Param;
import com.xiaobobo.crowdfunding.service.ParamService;


@Service("paramService")
public class ParamServiceImpl extends ServiceImpl<ParamDao, Param> implements ParamService {


}