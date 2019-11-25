package com.poc.springbbot.constants;

public class ErrorDetails extends RuntimeException {
	public String getField() {
		return Field;
	}

	public void setField(String field) {
		Field = field;
	}

	public String getDefaultMessage() {
		return DefaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		DefaultMessage = defaultMessage;
	}

	public String getObjectName() {
		return ObjectName;
	}

	public void setObjectName(String objectName) {
		ObjectName = objectName;
	}

	private String Field;
	private String DefaultMessage;
	private String ObjectName;

	/*
	 * public ErrorDetails(String Field, String DefaultMessage, String ObjectName) {
	 * //super(); this.Field = Field; this.DefaultMessage = DefaultMessage;
	 * this.ObjectName = ObjectName; }
	 */
}
