package com.xiaobobo.crowdfunding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:48
 */
@Data
@TableName("t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private String id;


    private String memberId;


    private String projectId;


    private String returnId;


    private String orderNum;


    private String createDate;


    private Integer money;


    private Integer returnCount;

    /**
     * 0 - 待付款， 1 - 交易完成， 9 - 交易关闭
     */

    private String status;


    private String address;

    /**
     * 0 - 不开发票， 1 - 开发票
     */

    private String invoice;


    private String invoicTitle;


    private String remark;

}
