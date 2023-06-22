package com.chatting.domain.dto.user;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    private String loginId;
    private String password;
}
