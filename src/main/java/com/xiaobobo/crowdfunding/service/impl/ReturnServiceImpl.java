package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.ReturnDao;
import com.xiaobobo.crowdfunding.entity.Return;
import com.xiaobobo.crowdfunding.service.ReturnService;


@Service("returnService")
public class ReturnServiceImpl extends ServiceImpl<ReturnDao, Return> implements ReturnService {


}