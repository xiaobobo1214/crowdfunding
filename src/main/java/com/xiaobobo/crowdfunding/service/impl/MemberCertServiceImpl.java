package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.MemberCertMapper;
import org.springframework.stereotype.Service;
import com.xiaobobo.crowdfunding.entity.MemberCert;
import com.xiaobobo.crowdfunding.service.MemberCertService;


@Service("memberCertService")
public class MemberCertServiceImpl extends ServiceImpl<MemberCertMapper, MemberCert> implements MemberCertService {


}