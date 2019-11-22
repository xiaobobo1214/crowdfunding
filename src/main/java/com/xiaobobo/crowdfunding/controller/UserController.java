package com.xiaobobo.crowdfunding.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobobo.crowdfunding.entity.User;
import com.xiaobobo.crowdfunding.service.UserService;
import com.xiaobobo.crowdfunding.utils.CommonUtils;
import com.xiaobobo.crowdfunding.utils.ConstUtils;
import com.xiaobobo.crowdfunding.utils.DateUtils;
import com.xiaobobo.crowdfunding.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/service/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;


    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    @PostMapping("/chkUsername")
    public Map<String, Object> chkUsername(@RequestParam String username) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);

        if (CommonUtils.isNotEmpty(userService.getOne(this.buildWrapper(params)))) {
            result.put("success", false);
            result.put("msg", "用户名已存在");
            return result;
        }

        result.put("success", true);
        return result;
    }


    /**
     * 保存用户
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/saveUser")
    public Map<String, Object> saveUser(@RequestBody User user) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        user.setId(CommonUtils.getID());
        user.setPassword(MD5Util.digest(user.getPassword()));
        user.setAuthStatus("0");
        user.setCreateTime(DateUtils.getCurrentTime());

        result.put("success", userService.save(user));
        return result;
    }

    /**
     * 查询所有用户 分页查
     * @param pageNo
     * @return
     * @throws Exception
     */
    @GetMapping("queryUsers")
    public Map<String, Object> queryUsers(@RequestParam(required = true, defaultValue = "1") int pageNo) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        PageHelper.startPage(pageNo, ConstUtils.PAGE_SIZE);

        List<User> list = userService.list();
        PageInfo<User> users = new PageInfo<User>(list);

        result.put("users", users);
        return result;
    }

    /**
     * 通用查询方法
     *
     * @param params
     * @return
     */
    private QueryWrapper<User> buildWrapper(Map<String, Object> params) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if (CommonUtils.isNotEmpty((String) params.get("username"))) {
            queryWrapper.eq("username", params.get("username"));
        }
        return queryWrapper;
    }


}
