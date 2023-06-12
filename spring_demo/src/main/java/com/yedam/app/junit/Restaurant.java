package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	@Autowired
	Chef chef;
	
	public void open() {
		chef.cooking();
	}
	
}
