package org.spring.transaction.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date")
	private Date birthDate;

	@OneToOne(cascade = CascadeType.ALL)
	private MailAddress mailAddress;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<Address>();

	@Column(name = "rating")
	private int rating;

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
		return id;
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
		return lastName;
	}

	public Customer setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Customer setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Customer add(final Address address) {
		Assert.notNull(address);
		this.addresses.add(address);
		return this;
	}

	public int getRating() {
		return rating;
	}

	public Customer setRating(final int rating) {
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
		if (!addresses.equals(customer.addresses)) {
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
		result = 31 * result + addresses.hashCode();
		result = 31 * result + rating;
		return result;
	}

	@Override
	public String toString() {
		return "Customer{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", birthDate=" + birthDate + ", addresses=" + addresses + ", rating=" + rating
				+ '}';
	}
}