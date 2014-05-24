package org.spring.transaction.enumeration;

public enum ProductCategoryEnum {

	CLOTHES("clothes & more"), ELECTRONICS("electronics & stuff"), MISC("all the rest.");

	private String descriptionValue;

	private ProductCategoryEnum(final String descriptionValue) {
		this.descriptionValue = descriptionValue;
	}

	public String getDescriptionValue() {
		return this.descriptionValue;
	}
}