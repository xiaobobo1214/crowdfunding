package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.MemberMapper;
import org.springframework.stereotype.Service;
import com.xiaobobo.crowdfunding.entity.Member;
import com.xiaobobo.crowdfunding.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {


}