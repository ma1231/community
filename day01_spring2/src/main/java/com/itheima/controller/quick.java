package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quick {

    @RequestMapping("/quick")
    public String quick2() {
        return "hello";
    }

}
