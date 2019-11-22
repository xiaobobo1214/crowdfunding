package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.CertDao;
import com.xiaobobo.crowdfunding.entity.Cert;
import com.xiaobobo.crowdfunding.service.CertService;


@Service("certService")
public class CertServiceImpl extends ServiceImpl<CertDao, Cert> implements CertService {


}