package org.spring.transaction.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.util.Assert;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MailAddress mailAddress;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Address> addressList = new ArrayList<Address>();

	@Column
	private Integer rating;

	/**
	 * 
	 * @param firstName
	 *            - must not be {@literal null}
	 * @param lastName
	 *            - must not be {@literal null}
	 */
	public Customer(final String firstName, final String lastName) {
		Assert.hasText(firstName);
		Assert.hasText(lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	protected Customer() {
	}

	public Long getId() {
		return this.id;
	}

	public Customer setId(final Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Customer setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Customer setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public List<Address> getAddressList() {
		return this.addressList;
	}

	public Customer addAddress(final Address address) {
		Assert.notNull(address);
		this.addressList.add(address);
		return this;
	}

	public Integer getRating() {
		return rating;
	}

	public Customer setRating(final Integer rating) {
		this.rating = rating;
		return this;
	}

	public MailAddress getMailAddress() {
		return mailAddress;
	}

	public Customer setMailAddress(final MailAddress mailAddress) {
		this.mailAddress = mailAddress;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer)) {
			return false;
		}
		final Customer customer = (Customer) o;
		if (rating != customer.rating) {
			return false;
		}
		if (!addressList.equals(customer.addressList)) {
			return false;
		}
		if (!birthDate.equals(customer.birthDate)) {
			return false;
		}
		if (!firstName.equals(customer.firstName)) {
			return false;
		}
		if (!lastName.equals(customer.lastName)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + birthDate.hashCode();
		result = 31 * result + addressList.hashCode();
		result = 31 * result + rating;
		return result;
	}

	@Override
	public String toString() {
		return "Customer{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", birthDate="
				+ birthDate + ", addresses=" + addressList + ", rating=" + rating + '}';
	}
}