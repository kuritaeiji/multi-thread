package com.threadpermessage;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyFrame {

	private final Axios axios;

	public void clickButton() throws InterruptedException {
		System.out.println("clicked button");
		axios.post(Map.of("name", "kurita"));
		System.out.println("click end");
	}
}
