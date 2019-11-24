package com.xiaobobo.crowdfunding.service.impl;

import com.xiaobobo.crowdfunding.dao.OrderMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobobo.crowdfunding.entity.Order;
import com.xiaobobo.crowdfunding.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


}