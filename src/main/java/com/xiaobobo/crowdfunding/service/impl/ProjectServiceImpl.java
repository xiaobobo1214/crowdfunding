package com.xiaobobo.crowdfunding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobobo.crowdfunding.dao.ProjectMapper;
import org.springframework.stereotype.Service;

import com.xiaobobo.crowdfunding.entity.Project;
import com.xiaobobo.crowdfunding.service.ProjectService;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {


}