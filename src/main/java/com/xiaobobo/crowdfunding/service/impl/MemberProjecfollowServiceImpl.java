package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.MemberProjecfollowDao;
import com.xiaobobo.crowdfunding.entity.MemberProjecfollow;
import com.xiaobobo.crowdfunding.service.MemberProjecfollowService;


@Service("memberProjecfollowService")
public class MemberProjecfollowServiceImpl extends ServiceImpl<MemberProjecfollowDao, MemberProjecfollow> implements MemberProjecfollowService {


}