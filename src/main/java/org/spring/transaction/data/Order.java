package org.spring.transaction.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	private List<Item> items = new ArrayList<Item>();

	@Column
	private BigDecimal discount;

	@ManyToOne
	private Customer customer;

	public Order(final Customer customer, final List<Item> items) {
		Assert.notNull(customer);
		Assert.notEmpty(items);
		this.customer = customer;
		this.items = items;
	}

	protected Order() {
	}

	@Override
	public String toString() {
		return "Order{" + "items=" + items + ", discount=" + discount + ", customer=" + customer
				+ '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Order)) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		final Order order = (Order) o;
		if (!customer.equals(order.customer)) {
			return false;
		}
		if (!discount.equals(order.discount)) {
			return false;
		}
		if (!items.equals(order.items)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + items.hashCode();
		result = 31 * result + discount.hashCode();
		result = 31 * result + customer.hashCode();
		return result;
	}

	public Long getId() {
		return id;
	}

	public Order setId(final Long id) {
		this.id = id;
		return this;
	}

	public List<Item> getItems() {
		return items;
	}

	public Order addItem(final Item item) {
		Assert.notNull(item);
		this.items.add(item);
		return this;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public Order setDiscount(final BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Order setCustomer(final Customer customer) {
		this.customer = customer;
		return this;
	}
}