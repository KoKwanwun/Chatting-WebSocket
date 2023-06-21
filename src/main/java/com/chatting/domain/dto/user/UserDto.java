package com.chatting.domain.dto.user;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String loginId;
    private String password;
    private String name;
}
