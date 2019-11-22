package com.xiaobobo.crowdfunding.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobobo.crowdfunding.entity.User;
import com.xiaobobo.crowdfunding.service.UserService;
import com.xiaobobo.crowdfunding.utils.CommonUtils;
import com.xiaobobo.crowdfunding.utils.MD5Util;
import com.xiaobobo.crowdfunding.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录有关的controller
 */
@RestController
@RequestMapping("/service/login")
@CrossOrigin(origins = "*",maxAge = 3600)
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登陆方法
     * @param params
     * @return
     */
    @PostMapping("/doLogin")
    public Map<String, Object> doLogin(@RequestBody Map<String, Object> params) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();

        String username = (String) params.get("username");
        String password = MD5Util.digest((String) params.get("password"));
        String redisKey = username + ":" + password;

        User user = null;
        user = (User) RedisUtils.get(redisKey);
        if(CommonUtils.isNotEmpty(user)){
            result.put("user",user);
            result.put("success",true);
            return result;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        user = userService.getOne(queryWrapper);
        if(CommonUtils.isNotEmpty(user)) {
            result.put("user", user);
            result.put("success", true);
            RedisUtils.set(redisKey, user, 1800);
        }else{
            result.put("success", false);
        }
        return result;
    }

}
