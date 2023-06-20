package com.chatting.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String main() {
        return "index";
    }

    @GetMapping("/user/signup")
    public String signUp() {
        return "signUp";
    }
}
