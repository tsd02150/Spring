package com.yedam.app.junit;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking() {
		System.out.println("세프가 요리를 시작합니다.");
	}
}
