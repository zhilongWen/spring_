package com.at.yuntai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2023-09-06
 */
@RestController
public class TestController {

    @GetMapping("/TEST")
    public String test(){
        return "12";
    }

}
