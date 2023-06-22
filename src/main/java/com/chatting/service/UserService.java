package com.chatting.service;

import com.chatting.domain.dto.user.UserDto;
import com.chatting.domain.dto.user.UserLoginRequest;
import com.chatting.domain.dto.user.UserSignUpRequest;
import com.chatting.domain.entity.User;
import com.chatting.execption.ApplicationException;
import com.chatting.execption.ErrorCode;
import com.chatting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public UserDto signUp(UserSignUpRequest request) {
        //회원가입 요청을 받을 때 이메일 인증을 했는지 안했는지 여부를 받아야하지 않을까..?

        String loginId = request.getLoginId();
        String password = request.getPassword();
        String name = request.getName();

        //가입 가능 여부 체크
        userRepository.findByLoginId(loginId).ifPresent(user -> {
            throw new ApplicationException(ErrorCode.DUPLICATED_EMAIL);
        });

        //정상 회원 저장 로직
        User user = request.toEntity(encoder.encode(password));
        User savedUser = userRepository.save(user);

        return savedUser.toDto();
    }

    public Boolean checkLoginId(String loginId) {
        Optional<User> findMember = userRepository.findByLoginId(loginId);
        if (findMember.isPresent()) {
            throw new ApplicationException(ErrorCode.DUPLICATED_EMAIL);
        } else {
            return true;
        }
    }

    public void login(UserLoginRequest request) {
        String loginId = request.getLoginId();
        String password = request.getPassword();

        // id가 DB에 존재하는지
        User user = userRepository.findByLoginId(loginId).orElseThrow(() -> {
            throw new ApplicationException(ErrorCode.USERId_NOT_FOUNDED);
        });

        //email-password 일치여부 확인
        if (!encoder.matches(password, user.getPassword())) {
            throw new ApplicationException(ErrorCode.INVALID_PASSWORD);
        }
    }
}
