package com.example.webui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestUIController {

        //读取配置中心的参数
        @Value("${sysconfig.isDebug}")
        private Boolean isDebug;

        @RequestMapping("testUI/page1")
        public String page1(){
                return "webUI page1. current time:"+(new Date()).toString();
        }

        @RequestMapping("testUI/page2")
        public String page2(){return "webUI page2.sysconfig.isDebug="+isDebug.toString();}
}
