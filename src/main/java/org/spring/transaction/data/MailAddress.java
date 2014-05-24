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

	@Column(name = "mail_address", unique = true, nullable = false)
	private String mailAddress;

	public MailAddress(final String mailAddress) {
		Assert.isTrue(isValid(mailAddress));
		this.mailAddress = mailAddress;
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
		return mailAddress;
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
		return this.mailAddress.equals(that.mailAddress);
	}

	@Override
	public int hashCode() {
		return mailAddress.hashCode();
	}
}