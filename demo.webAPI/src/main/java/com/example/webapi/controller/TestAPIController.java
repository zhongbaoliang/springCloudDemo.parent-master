package com.example.webapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestAPIController {

        //读取配置中心的参数
        @Value("${sysconfig.isDebug}")
        private Boolean isDebug;

        @RequestMapping("testAPI/page1")
        public String page1(){
                return "webAPI page1. current time:"+(new Date()).toString();
        }

        @RequestMapping("testAPI/page2")
        public String page2(){return "webAPI page2.sysconfig.isDebug="+isDebug.toString();}
}
