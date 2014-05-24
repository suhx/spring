package org.spring.transaction.data;

public enum ProductCategory {

	CLOTHES("clothes & more"), ELECTRONICS("electronics & stuff"), MISC("all the rest.");

	private String descriptionValue;

	private ProductCategory(final String descriptionValue) {
		this.descriptionValue = descriptionValue;
	}

	public String getDescriptionValue() {
		return this.descriptionValue;
	}
}