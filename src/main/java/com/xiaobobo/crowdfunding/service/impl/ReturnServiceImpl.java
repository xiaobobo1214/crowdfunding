package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.ReturnMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Return;
import com.xiaobobo.crowdfunding.service.ReturnService;


@Service("returnService")
public class ReturnServiceImpl extends ServiceImpl<ReturnMapper, Return> implements ReturnService {


}