package org.spring.transaction.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String street;

	@Column(name = "additional_address_info")
	private String additionalAddressInfo;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private int number;

	public Address(final String street, final int number, final String postalCode, final String city,
			final String country) {
		Assert.hasText(street);
		Assert.hasText(postalCode);
		Assert.hasText(city);
		Assert.hasText(country);
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.number = number;
	}

	protected Address() {
	}

	public Long getId() {
		return id;
	}

	public Address setId(final Long id) {
		this.id = id;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public Address setStreet(final String street) {
		this.street = street;
		return this;
	}

	public int getNumber() {
		return number;
	}

	public Address setNumber(final int number) {
		this.number = number;
		return this;
	}

	public String getAdditionalAddressInfo() {
		return additionalAddressInfo;
	}

	public Address setAdditionalAddressInfo(final String additionalAddressInfo) {
		this.additionalAddressInfo = additionalAddressInfo;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Address setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(final String city) {
		this.city = city;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(final String country) {
		this.country = country;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalAddressInfo == null) ? 0 : additionalAddressInfo.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + number;
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Address other = (Address) obj;
		if (additionalAddressInfo == null) {
			if (other.additionalAddressInfo != null) {
				return false;
			}
		} else if (!additionalAddressInfo.equals(other.additionalAddressInfo)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (number != other.number) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Adress [street=" + street + ", number=" + number + ", additionalAddressInfo=" + additionalAddressInfo
				+ ", postalCode=" + postalCode + ", city=" + city + ", country=" + country + "]";
	}
}