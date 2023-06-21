package com.chatting.controller.rest;

import com.chatting.domain.Response;
import com.chatting.domain.dto.user.UserDto;
import com.chatting.domain.dto.user.UserLoginIdRequest;
import com.chatting.domain.dto.user.UserSignUpRequest;
import com.chatting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
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
}
