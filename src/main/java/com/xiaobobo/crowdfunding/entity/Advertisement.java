package com.xiaobobo.crowdfunding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:53
 */
@Data
@TableName("t_advertisement")
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private String id;
    private String name;
    private String iconpath;
    /**
     * 0 - 草稿， 1 - 未审核， 2 - 审核完成， 3 - 发布
     */
    private String status;
    private String url;
    private String userid;

}
