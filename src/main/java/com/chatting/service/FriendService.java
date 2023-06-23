package com.chatting.service;

import com.chatting.domain.dto.friend.FriendDto;
import com.chatting.domain.entity.Friend;
import com.chatting.domain.entity.User;
import com.chatting.execption.ApplicationException;
import com.chatting.execption.ErrorCode;
import com.chatting.repository.FriendRepository;
import com.chatting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FriendService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    public FriendDto addFriend(String loginId, String friendLoginId) {
        // 본인은 추가 불가
        if (loginId.equals(friendLoginId)) {
            throw new ApplicationException(ErrorCode.CANT_ADD_FRIEND_MYSELF);
        }

        // 유저 id가 DB에 존재하는지
        User user = userRepository.findByLoginId(loginId).orElseThrow(() -> {
            throw new ApplicationException(ErrorCode.USERId_NOT_FOUNDED);
        });

        // 친구 id가 DB에 존재하는지
        User friend = userRepository.findByLoginId(friendLoginId).orElseThrow(() -> {
            throw new ApplicationException(ErrorCode.USERId_NOT_FOUNDED);
        });

        // 이미 친추가 되어 있다면
        Optional<Friend> friendList = friendRepository.findByUser_idAndFriend_id(user.getId(), friend.getId());
        if (friendList.isPresent()) {
            throw new ApplicationException(ErrorCode.ALREADY_ADD_FRIEND);
        }

        Friend savedFriend = friendRepository.save(Friend.builder()
                .user(user)
                .friend(friend)
                .build());

        return savedFriend.toDto();
    }
}
