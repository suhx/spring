package org.spring.transaction.enumeration;

public enum OrderEnum {

	GREATER("greater"), LOWER("lower");

	private String order;

	private OrderEnum(final String order) {
		this.order = order;
	}

	public String getOrder() {
		return this.order;
	}
}
