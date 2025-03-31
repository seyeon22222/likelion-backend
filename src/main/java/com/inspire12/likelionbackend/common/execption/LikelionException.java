package com.inspire12.likelionbackend.common.execption;

import lombok.Getter;

@Getter
public class LikelionException extends RuntimeException {
    // TODO
	private final ErrorCode errorCode;

	public LikelionException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
