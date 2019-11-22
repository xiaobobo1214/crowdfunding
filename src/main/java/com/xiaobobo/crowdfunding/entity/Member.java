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
@TableName("t_member")
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private String id;
    private String username;
    private String password;
    private String concat;
    private String email;
    /**
     * 实名认证状态 0 - 未实名认证， 1 - 实名认证申请中， 2 - 已实名认证
     */
    private String authStatus;
    /**
     * 0 - 个人， 1 - 企业
     */

    private String userType;
    private String realName;
    private String cardNum;
    /**
     * 0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府
     */
    private String accountType;

}
