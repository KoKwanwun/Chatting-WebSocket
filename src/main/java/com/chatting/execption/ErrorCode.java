package com.chatting.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "Email이 중복됩니다."),
    USERId_NOT_FOUNDED(HttpStatus.NOT_FOUND, "아이디를 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.NOT_FOUND, "패스워드가 잘못되었습니다."),
    CANT_ADD_FRIEND_MYSELF(HttpStatus.CONFLICT, "본인은 친구 추가할 수 없습니다."),
    ALREADY_ADD_FRIEND(HttpStatus.CONFLICT, "이미 친구 추가가 되어 있습니다.");

    private HttpStatus status;
    private String message;

}