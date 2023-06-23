package com.chatting.domain.dto.friend;

import com.chatting.domain.entity.User;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendDto {
    private Long id;
    private User userLoginId;
    private User friendLoginId;
}
