package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.xiaobobo.crowdfunding.dao.TypeMapper;
import com.xiaobobo.crowdfunding.entity.Type;
import com.xiaobobo.crowdfunding.service.TypeService;


@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {


}