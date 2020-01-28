package com.github.mall.controller;


import com.alibaba.fastjson.JSON;
import com.github.mall.common.ApiResult;
import com.github.mall.dao.UmsAdminDao;
import com.github.mall.entity.UmsAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author wy
 * @since 2019-09-12
 */
@RestController
@RequestMapping("/ums")
@Slf4j
@Api(tags = "后台用户模块")
public class UmsAdminController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册接口")
    public ApiResult register(@RequestParam("username") String userName) {
        log.info("进来了........");

        return ApiResult.success("ok");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口")
   // @LoginOperation(value = "login")
    public ApiResult login(@RequestParam("username") String userName,
                           @RequestParam("password") String passWord) {
        log.info("================" + userName + "登录进来===========");

     //   String jwt = JwtTokenUtil.createJWT(userName);
       //     UsernamePasswordToken token=new UsernamePasswordToken(userName,passWord);
       //     Subject subject = SecurityUtils.getSubject();
        //    subject.login(token);
        return ApiResult.success("ok");
    }


    @Resource
    UmsAdminDao umsAdminDao;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public String getUserInfo() {
        UmsAdmin umsAdmin = umsAdminDao.selectById(1);
        log.info("用户{}", JSON.toJSONString(umsAdmin));
        return "ok";
    }

}

