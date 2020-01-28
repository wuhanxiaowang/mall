package com.github.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/12 13:47
 * @ModifyDate 2019/9/12 13:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
@Api(tags = "视图模块")
public class ViewController {

    @RequestMapping(value = "/register")
    @ApiOperation(value = "注册接口")
    public String register(){

        return "register";
    }

    @RequestMapping(value = "/login")
    @ApiOperation(value = "登录接口")
    public String login(){

        return "login";
    }




}
