package com.xiaobobo.crowdfunding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:43
 */
@Data
@TableName("t_return")
public class Return implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@TableId
	private String id;

	
	private String projectId;

		/**
	 * 0 - 实物回报， 1 虚拟物品回报
	 */
	
	private String type;

	
	private Integer supportMoney;

	
	private String content;

		/**
	 * “0”为不限回报数量
	 */
	
	private Integer count;

	
	private Integer signalPurchase;

	
	private Integer purchase;

	
	private Integer freight;

		/**
	 * 0 - 不开发票， 1 - 开发票
	 */
	
	private String invoice;

	
	private Integer returnDate;

}
