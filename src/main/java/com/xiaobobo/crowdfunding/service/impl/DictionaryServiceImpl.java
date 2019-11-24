package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.DictionaryMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Dictionary;
import com.xiaobobo.crowdfunding.service.DictionaryService;


@Service("dictionaryService")
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {


}