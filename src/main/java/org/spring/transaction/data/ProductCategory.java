package org.spring.transaction.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.transaction.enumeration.ProductCategoryEnum;

@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private ProductCategoryEnum category;

	protected ProductCategory() {
	}

	public ProductCategory(final ProductCategoryEnum category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public ProductCategory setId(final Long id) {
		this.id = id;
		return this;
	}

	public ProductCategoryEnum getName() {
		return category;
	}

	public ProductCategory setCategory(final ProductCategoryEnum category) {
		this.category = category;
		return this;
	}
}