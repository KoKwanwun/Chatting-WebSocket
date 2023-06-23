package com.chatting.repository;

import com.chatting.domain.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    Optional<Friend> findByUser_idAndFriend_id(Long userId, Long friendId);

    List<Friend> findByUser_id(Long userId);
}
