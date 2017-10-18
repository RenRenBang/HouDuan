package com.soecode.lyf.exception;

/**
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6312191138191776228L;

	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
