package com.chatting.domain.dto.user;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEmailRequest {
    private String email;
}
