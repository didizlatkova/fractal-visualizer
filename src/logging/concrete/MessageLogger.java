package logging.concrete;

import logging.abstracts.*;

public class MessageLogger implements Logger {

	private static MessageLogger instance = new MessageLogger();

	private static boolean shouldLog;

	private MessageLogger() {

	}

	public static void setShouldLog(boolean shouldLog) {
		MessageLogger.shouldLog = shouldLog;
	}

	public static MessageLogger getInstance() {
		return instance;
	}

	public void log(String message) {
		if (MessageLogger.shouldLog) {
			System.out.println(message);
		}
	}

	@Override
	public void logAlways(String message) {
		System.out.println(message);
	}
	
}
