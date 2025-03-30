package com.inspire12.likelionbackend.common.execption;

import lombok.Getter;

@Getter
public class LikelionException extends RuntimeException {
    private final ErrorCode errorCode;

    public LikelionException() {
        super("likelion error");
        this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public LikelionException(ErrorCode errorCode) {
        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }
}
