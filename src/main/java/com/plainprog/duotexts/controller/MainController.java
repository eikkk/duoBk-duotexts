package com.plainprog.duotexts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/duotexts")
    public String duotexts(){
        return "duotexts";
    }
}
