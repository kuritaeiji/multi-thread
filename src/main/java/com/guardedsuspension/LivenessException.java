package com.guardedsuspension;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LivenessException extends RuntimeException {

	private final String msg;
}
