package com.chatting.controller.rest;

import com.chatting.domain.Response;
import com.chatting.domain.dto.friend.FriendDto;
import com.chatting.domain.dto.user.UserSignUpRequest;
import com.chatting.service.FriendService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/friend")
@RequiredArgsConstructor
@Slf4j
public class FriendRestController {

    private final FriendService friendService;

    //== 친구추가 요청 ==//
    @PostMapping("/add")
    public Response<FriendDto> addFriend(@RequestBody UserSignUpRequest userSignUpRequest,
                                         HttpServletRequest request) {

        FriendDto friendDto = friendService.addFriend((String) request.getSession().getAttribute("loginId"), userSignUpRequest.getLoginId());

        return Response.success(friendDto);
    }
}
