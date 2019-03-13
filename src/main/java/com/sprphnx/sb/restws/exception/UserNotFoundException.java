package com.sprphnx.sb.restws.exception;

public class UserNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;
	private String message;
	private String details;

	public UserNotFoundException(String message, String details) {
		super();
		this.code = "ERR_101";
		this.message = message;
		this.details = details;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
