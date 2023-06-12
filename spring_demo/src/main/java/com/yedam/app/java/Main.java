package com.yedam.app.java;

public class Main {
	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.on();
		tv=new LGTV();
		tv.on();
	}
}
