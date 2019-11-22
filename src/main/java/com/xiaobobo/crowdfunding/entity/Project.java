package com.xiaobobo.crowdfunding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:43
 */
@Data
@TableName("t_project")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private String id;


    private String name;


    private String remark;


    private Integer money;


    private Integer day;

    /**
     * 0 - 即将开始， 1 - 众筹中， 2 - 众筹成功， 3 - 众筹失败
     */

    private String status;


    private String deployDate;


    private Long supportMoney;


    private Integer supporter;


    private Integer completion;


    private String memberId;


    private String createDate;


    private Integer follower;

}
