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
public class HelloController {
    @Value("${spring.profiles.active}")
    private String activityProfile;

    /**
     * hello
     * @return
     */
    @ApiOperation(value = "hello1",notes = "接口说明信息",tags = "首页相关")
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 1, message = "失败"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",defaultValue = "xxx",paramType = "query",required=true),
            @ApiImplicitParam(name = "age",value = "年龄",defaultValue = "6",paramType = "query",required=true),
    })
    @GetMapping
    public String hello1(@ApiParam(name = "address",value = "地址",defaultValue = "中国",required=true) String address){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }

    @ApiOperation(value = "hello2",notes = "接口说明信息",tags = "首页相关")
    @GetMapping("hello2")
    public String hello2(@ApiParam(name = "address",value = "地址",defaultValue = "中国",required=true) String address){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }

    @ApiOperation(value = "red1",notes = "接口说明信息",tags = "首页相关")
    @GetMapping("red1")
    public String red1(@ApiParam(name = "address",value = "地址",defaultValue = "中国",required=true) String address){
        String nowTime = LocalDateTime.now().toString();
        String hello = "hello words in "+activityProfile+" at: "+nowTime;
        log.info(hello);
        return hello;
    }
}
