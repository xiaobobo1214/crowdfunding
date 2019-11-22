package com.xiaobobo.crowdfunding;


import com.xiaobobo.crowdfunding.entity.User;
import com.xiaobobo.crowdfunding.service.UserService;
import com.xiaobobo.crowdfunding.utils.MD5Util;
import com.xiaobobo.crowdfunding.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@MapperScan("com.xiaobobo.crowdfunding.mapper")
@SpringBootTest
public class CrowdfundingApplicationTests {



    @Test
    void test1(){
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.digest("123456"));
    }


}
