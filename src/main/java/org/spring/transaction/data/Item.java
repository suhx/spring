package org.spring.transaction.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private ProductCategory category;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "long_description")
	private String longDescription;

	@Column(name = "price")
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public Item setId(final Long id) {
		this.id = id;
		return this;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public Item setCategory(final ProductCategory category) {
		this.category = category;
		return this;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public Item setShortDescription(final String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public Item setLongDescription(final String longDescription) {
		this.longDescription = longDescription;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Item setPrice(final BigDecimal price) {
		this.price = price;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Item)) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		final Item item = (Item) o;
		if (category != item.category) {
			return false;
		}
		if (!longDescription.equals(item.longDescription)) {
			return false;
		}
		if (!price.equals(item.price)) {
			return false;
		}
		if (!shortDescription.equals(item.shortDescription)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + category.hashCode();
		result = 31 * result + shortDescription.hashCode();
		result = 31 * result + longDescription.hashCode();
		result = 31 * result + price.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Item{" + "category=" + category + ", shortDescription='" + shortDescription + '\''
				+ ", longDescription='" + longDescription + '\'' + ", price=" + price + '}';
	}
}