package org.spring.transaction.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.util.Assert;

@Entity
@Table(name = "ordering")
public class Ordering {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Item> items = new ArrayList<Item>();

	@Column
	private BigDecimal discount;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;

	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public Ordering(final Customer customer, final List<Item> items) {
		Assert.notNull(customer);
		Assert.notEmpty(items);
		this.customer = customer;
		this.items = items;
	}

	protected Ordering() {
	}

	@Override
	public String toString() {
		return "Order{" + "items=" + items + ", discount=" + discount + ", customer=" + customer + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Ordering)) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		final Ordering ordering = (Ordering) o;
		if (!customer.equals(ordering.customer)) {
			return false;
		}
		if (!discount.equals(ordering.discount)) {
			return false;
		}
		if (!items.equals(ordering.items)) {
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

	public Ordering setId(final Long id) {
		this.id = id;
		return this;
	}

	public List<Item> getItems() {
		return items;
	}

	public Ordering addItem(final Item item) {
		Assert.notNull(item);
		this.items.add(item);
		return this;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public Ordering setDiscount(final BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Ordering setCustomer(final Customer customer) {
		this.customer = customer;
		return this;
	}
}