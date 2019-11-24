package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.MemberAddressMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.MemberAddress;
import com.xiaobobo.crowdfunding.service.MemberAddressService;


@Service("memberAddressService")
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressMapper, MemberAddress> implements MemberAddressService {


}