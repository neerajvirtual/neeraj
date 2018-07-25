package com.demo.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ApplicationConstants {

	private long uniqueNumber=0;

	public long getUniqueNumber() {
		return this.uniqueNumber;
	}

	public void setUniqueNumber(long uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	
}