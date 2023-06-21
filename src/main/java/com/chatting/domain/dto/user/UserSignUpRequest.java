package com.chatting.domain.dto.user;

import com.chatting.domain.entity.User;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {
    private String loginId;
    private String password;
    private String name;

    public User toEntity(String enCodedPassword) {
        return User.builder()
                .loginId(this.loginId)
                .password(enCodedPassword)
                .name(this.name)
                .build();
    }
}
