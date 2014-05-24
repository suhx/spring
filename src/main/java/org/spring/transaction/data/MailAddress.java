package org.spring.transaction.data;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "mail_address")
public class MailAddress {

	@Id
	@GeneratedValue
	private Long id;

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

	@Column(unique = true)
	private String value;

	public MailAddress(final String mailAddress) {
		Assert.isTrue(isValid(mailAddress));
		this.value = mailAddress;
	}

	protected MailAddress() {
	}

	public static boolean isValid(final String candidate) {
		return candidate == null ? false : PATTERN.matcher(candidate).matches();
	}

	public Long getId() {
		return id;
	}

	public MailAddress setId(final Long id) {
		this.id = id;
		return this;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MailAddress)) {
			return false;
		}
		final MailAddress that = (MailAddress) obj;
		return this.value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}