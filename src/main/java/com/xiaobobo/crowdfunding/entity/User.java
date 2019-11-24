package com.xiaobobo.crowdfunding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author xiaobobo
 * @email 994301552@qq.com
 * @date 2019-11-21 10:45:43
 */
@Data
@TableName("t_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private String id;
	private String username;
	private String password;
	private String name;
	private String concat;
	private String email;
	private String createTime;
	private String authStatus;

}
