package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.MemberCertDao;
import com.xiaobobo.crowdfunding.entity.MemberCert;
import com.xiaobobo.crowdfunding.service.MemberCertService;


@Service("memberCertService")
public class MemberCertServiceImpl extends ServiceImpl<MemberCertDao, MemberCert> implements MemberCertService {


}