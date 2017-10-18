package com.soecode.lyf.exception;

/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282894761225872660L;

	public RepeatAppointException(String message) {
		super(message);
	}

	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
	}

}
