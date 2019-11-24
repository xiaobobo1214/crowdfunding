package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.CertMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Cert;
import com.xiaobobo.crowdfunding.service.CertService;


@Service("certService")
public class CertServiceImpl extends ServiceImpl<CertMapper, Cert> implements CertService {


}