package com.xiaobobo.crowdfunding.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.dao.AdvertisementDao;
import com.xiaobobo.crowdfunding.entity.Advertisement;
import com.xiaobobo.crowdfunding.service.AdvertisementService;


@Service("advertisementService")
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementDao, Advertisement> implements AdvertisementService {


}