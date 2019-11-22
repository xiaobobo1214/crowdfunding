package com.xiaobobo.crowdfunding.dao;

import com.xiaobobo.crowdfunding.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:48
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {
	
}
