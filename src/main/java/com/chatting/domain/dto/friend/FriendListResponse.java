package com.chatting.domain.dto.friend;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendListResponse {

    private String loginId;
    private String name;
}
