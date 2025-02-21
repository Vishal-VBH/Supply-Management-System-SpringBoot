package com.supplychainmanagementsystem.exceptionpackage;

public class NoRecordFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No Record Found in Database";
	}
}
