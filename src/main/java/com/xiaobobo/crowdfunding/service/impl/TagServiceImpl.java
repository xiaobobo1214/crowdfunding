package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.TagMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Tag;
import com.xiaobobo.crowdfunding.service.TagService;


@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


}