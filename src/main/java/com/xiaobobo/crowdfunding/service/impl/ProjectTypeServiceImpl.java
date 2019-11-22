package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.ProjectTypeDao;
import com.xiaobobo.crowdfunding.entity.ProjectType;
import com.xiaobobo.crowdfunding.service.ProjectTypeService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("projectTypeService")
public class ProjectTypeServiceImpl extends ServiceImpl<ProjectTypeDao, ProjectType> implements ProjectTypeService {


}