package com.chatting.controller.front;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping
    public String main(HttpServletRequest request) {

        String loginId = (String) request.getSession().getAttribute("loginId");

        if (loginId == null) {
            return "login";
        }

        return "index";
    }

    @GetMapping("/user/signup")
    public String signUp() {
        return "signUp";
    }

    @GetMapping("/friend/add")
    public String addFriend() {
        return "addFriend";
    }
}
