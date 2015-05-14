package logging.concrete;

import logging.abstracts.*;

public class MessageLogger implements Logger {
	
	private boolean shouldLog;
	
	public MessageLogger(boolean shouldLog){
		this.shouldLog = shouldLog;
	}

	public void log(String message){
		if (this.shouldLog) {
			System.out.println(message);
		}
	}

	@Override
	public void logAlways(String message) {
		System.out.println(message);		
	}
}
