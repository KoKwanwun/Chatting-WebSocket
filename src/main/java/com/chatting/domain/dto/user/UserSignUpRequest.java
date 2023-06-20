package com.chatting.domain.dto.user;

import com.chatting.domain.entity.User;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {
    private String email;
    private String password;
    private String name;

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }
}
