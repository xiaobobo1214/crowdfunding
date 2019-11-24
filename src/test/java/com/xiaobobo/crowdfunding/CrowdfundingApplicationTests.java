package com.xiaobobo.crowdfunding;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobobo.crowdfunding.entity.User;
import com.xiaobobo.crowdfunding.service.UserService;
import com.xiaobobo.crowdfunding.utils.CommonUtils;
import com.xiaobobo.crowdfunding.utils.DateUtils;
import com.xiaobobo.crowdfunding.utils.MD5Util;
import com.xiaobobo.crowdfunding.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapperScan("com.xiaobobo.crowdfunding.dao")
@SpringBootTest
public class CrowdfundingApplicationTests {


    @Autowired
    private UserService userService;


    @Test
    void test1() throws Exception {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(CommonUtils.getID());
            user.setUsername("test" + i);
            user.setName("测试人员" + i + "号");
            user.setPassword(MD5Util.digest("123"));
            user.setEmail("test" + i + "@test.com");
            user.setConcat("13287708390");
            user.setCreateTime(DateUtils.getCurrentTime());
            users.add(user);
        }
        userService.saveBatch(users);


    }

    public static void main(String[] args) {
        System.out.println(MD5Util.digest("123456"));
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
