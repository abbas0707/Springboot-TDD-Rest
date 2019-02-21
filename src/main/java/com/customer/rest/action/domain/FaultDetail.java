package com.customer.rest.action.domain;

import java.util.Date;

public class FaultDetail {
	private Date timestamp;
	private String message;
	private String errorDetail;

	public FaultDetail(Date timestamp, String message, String errorDetail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetail = errorDetail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

}
