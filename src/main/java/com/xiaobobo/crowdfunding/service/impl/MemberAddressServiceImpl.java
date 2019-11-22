package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.MemberAddressDao;
import com.xiaobobo.crowdfunding.entity.MemberAddress;
import com.xiaobobo.crowdfunding.service.MemberAddressService;


@Service("memberAddressService")
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressDao, MemberAddress> implements MemberAddressService {


}