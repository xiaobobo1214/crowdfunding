package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.ProjectTagMapper;
import com.xiaobobo.crowdfunding.entity.ProjectTag;
import com.xiaobobo.crowdfunding.service.ProjectTagService;
import org.springframework.stereotype.Service;



@Service("projectTagService")
public class ProjectTagServiceImpl extends ServiceImpl<ProjectTagMapper, ProjectTag> implements ProjectTagService {


}