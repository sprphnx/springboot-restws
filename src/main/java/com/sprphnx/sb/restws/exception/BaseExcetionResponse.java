package com.sprphnx.sb.restws.exception;

import java.util.Date;

public class BaseExcetionResponse {

	private Date timestamp;
	private String code;
	private String message;
	private String details;

	public BaseExcetionResponse(Date timestamp, String code, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
