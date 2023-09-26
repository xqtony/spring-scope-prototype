package com.xqtony.bean.scope.prototype.rest;

import com.xqtony.bean.scope.prototype.service.MyService;
import com.xqtony.bean.scope.prototype.service.MyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MyController {
    @Autowired
    private MyService service;
    @Autowired
    private MyService2 service2;
    private static int num=0;
    @GetMapping("scope1")
    public void testScope1(){
        System.out.println("num:"+ num +"次请求, service没加  ScopeProxyMode"+ service);
        System.out.println("num:"+ num++ +"次请求, service加了 ScopeProxyMode.TARGET_CLASS"+ service2);
    }

}