package com.supplychainmanagementsystem.exceptionpackage;

public class NameNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Name Not Found in dB";
	}
	
}
