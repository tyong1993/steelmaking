package com.steel.application.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@Api(tags = "所有接口",description = " ")
public class UserController {
    @Value("${spring.profiles.active}")
    private String activityProfile;

    @ApiOperation(value = "user1",notes = "接口说明信息",tags = "用户相关")
    @GetMapping("user1")
    public String user1(){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }
    @ApiOperation(value = "user2",notes = "接口说明信息",tags = "用户相关")
    @GetMapping("user2")
    public String user2(){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }
    @ApiOperation(value = "user3",notes = "接口说明信息",tags = "用户相关")
    @GetMapping("user3")
    public String user3(){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }
}
