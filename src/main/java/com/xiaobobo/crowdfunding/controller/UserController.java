package com.xiaobobo.crowdfunding.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
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
    @PostMapping("/chkUsername/{username}")
    public Map<String, Object> chkUsername(@PathVariable String username) throws Exception {
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
    @GetMapping("/queryUsers")
    public Map<String, Object> queryUsers(@RequestParam(name = "pageNo",required = true, defaultValue = "1") int pageNo,
                                          @RequestParam(name = "key",required = false) String key){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<User> page = PageHelper.startPage(pageNo, ConstUtils.PAGE_SIZE);
            Map<String, Object> wrapperMap = new HashMap<String, Object>();
            wrapperMap.put("key", key);
            List<User> list = userService.list(this.buildWrapper(wrapperMap));
            PageInfo<User> users = new PageInfo<User>(list);

            result.put("users", users);
            result.put("success", true);
        }catch (Exception e){
            result.put("success", false);
        }
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
        if (CommonUtils.isNotEmpty((String) params.get("key"))) {
            String key = (String) params.get("key");
            queryWrapper.like("username", key).or().like("name", key)
                    .or().like("concat", key).or().like("email", key);
        }
        return queryWrapper;
    }



}
