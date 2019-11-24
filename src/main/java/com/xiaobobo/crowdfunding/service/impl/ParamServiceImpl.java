package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.ParamMapper;
import org.springframework.stereotype.Service;

import com.xiaobobo.crowdfunding.entity.Param;
import com.xiaobobo.crowdfunding.service.ParamService;


@Service("paramService")
public class ParamServiceImpl extends ServiceImpl<ParamMapper, Param> implements ParamService {


}