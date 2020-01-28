package com.github.mall.controller;

import cn.hutool.core.util.RandomUtil;
import com.github.mall.common.ApiResult;
import com.github.mall.entity.User;
import com.github.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/17 19:39
 * @ModifyDate 2019/9/17 19:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试")
@Slf4j
public class HelloController {

    @Autowired
    UmsAdminService umsAdminService;

    //@Autowired
    // RedisUtil redisUtil;

    //  @Autowired
    //  HelloSender helloSender;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ApiResult hello() throws IOException {
        // ApiResult apiResult = umsAdminService.getUser();
        //  redisUtil.set("WY","132456");
        //  helloSender.send();
        long time1=System.currentTimeMillis();
        List<User> userList=new ArrayList<>();
        for(int i=0;i<1000000;i++){
            User user=new User();
            user.setAge(RandomUtil.randomInt());
            user.setName(RandomUtil.randomString(6));
            user.setPhone(RandomUtil.randomString(11));
            user.setEmail(RandomUtil.randomString(8));
            userList.add(user);
        }
        log.info("耗时{}",System.currentTimeMillis()-time1);
        return ApiResult.success("成功");


    }
}
