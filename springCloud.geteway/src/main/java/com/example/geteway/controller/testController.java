package com.example.geteway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class testController {

    //读取配置中心的参数
    @Value("${sysconfig.isDebug}")
    private Boolean isDebug;

    @RequestMapping("test/page1")
    public String page1(){
        return "getway page1. current time:"+(new Date()).toString();
    }

    @RequestMapping("test/page2")
    public String page2(){return "getway page2.sysconfig.isDebug="+isDebug.toString();}
}
