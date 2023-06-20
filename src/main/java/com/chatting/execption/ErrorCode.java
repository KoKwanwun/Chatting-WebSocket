package com.chatting.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "Email이 중복됩니다.");

    private HttpStatus status;
    private String message;

}