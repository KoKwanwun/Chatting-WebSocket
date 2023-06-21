package com.chatting.controller.rest;

import com.chatting.domain.Response;
import com.chatting.domain.dto.user.UserDto;
import com.chatting.domain.dto.user.UserLoginIdRequest;
import com.chatting.domain.dto.user.UserSignUpRequest;
import com.chatting.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SignUpRestController {

    private final SignUpService signUpService;

    //== 회원가입 요청 ==//
    @PostMapping("/signup")
    public Response<String> join(@RequestBody UserSignUpRequest userSignUpRequest) {
        UserDto userDto = signUpService.signUp(userSignUpRequest);
        return Response.success("회원가입 성공");
    }

    //== 회원가입 이메일 확인 ==//
    @PostMapping("/check/loginId")
    public Boolean checkLoginId(@RequestBody UserLoginIdRequest userLoginIdRequest) {

        String loginId = userLoginIdRequest.getLoginId();

        return signUpService.checkLoginId(loginId);
    }
}
