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
@TableName("t_member_project_follow")
public class MemberProjecfollow implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private String id;


    private String projectId;


    private String memberId;

}
