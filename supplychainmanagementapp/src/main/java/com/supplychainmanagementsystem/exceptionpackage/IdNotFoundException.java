package com.supplychainmanagementsystem.exceptionpackage;

public class IdNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Id Not Found in dB";
	}
}
