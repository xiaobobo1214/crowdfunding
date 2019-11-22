package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.MemberDao;
import com.xiaobobo.crowdfunding.entity.Member;
import com.xiaobobo.crowdfunding.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {


}