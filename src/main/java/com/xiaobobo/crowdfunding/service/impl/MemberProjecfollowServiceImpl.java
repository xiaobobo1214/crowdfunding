package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.MemberProjectFollowMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.MemberProjecfollow;
import com.xiaobobo.crowdfunding.service.MemberProjecfollowService;


@Service("memberProjecfollowService")
public class MemberProjecfollowServiceImpl extends ServiceImpl<MemberProjectFollowMapper, MemberProjecfollow> implements MemberProjecfollowService {


}