package com.chatting.controller.rest;

import com.chatting.domain.Response;
import com.chatting.domain.dto.user.UserDto;
import com.chatting.domain.dto.user.UserLoginIdRequest;
import com.chatting.domain.dto.user.UserLoginRequest;
import com.chatting.domain.dto.user.UserSignUpRequest;
import com.chatting.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    //== 회원가입 요청 ==//
    @PostMapping("/signup")
    public Response<String> join(@RequestBody UserSignUpRequest userSignUpRequest) {
        UserDto userDto = userService.signUp(userSignUpRequest);
        return Response.success("회원가입 성공");
    }

    //== 회원가입 이메일 확인 ==//
    @PostMapping("/signup/check/loginId")
    public Boolean checkLoginId(@RequestBody UserLoginIdRequest userLoginIdRequest) {

        String loginId = userLoginIdRequest.getLoginId();

        return userService.checkLoginId(loginId);
    }

    //== 로그인 요청 ==//
    @PostMapping("/login")
    public void login(@RequestBody UserLoginRequest userLoginRequest,
                      HttpServletRequest request) {

        userService.login(userLoginRequest);

        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        request.getSession().invalidate();
        HttpSession session = request.getSession(true);  // Session이 없으면 생성

        // 세션에 loginId을 넣어줌
        session.setAttribute("loginId", userLoginRequest.getLoginId());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지
    }

    //== 로그아웃 요청 ==//
    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
