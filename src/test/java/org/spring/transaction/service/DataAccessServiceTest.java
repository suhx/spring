package org.spring.transaction.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.transaction.data.Address;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.MailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DataAccessServiceTest {

	@Autowired
	private DataAccessService dataAccessService;

	private String firstName = "firstName";
	private String lastName = "lastName";
	private Date birthDate = new Date();
	private MailAddress mailAddress = new MailAddress("test@test.de");
	private int rating = 8;
	private Address address = new Address("street", 8, "zip", "city", "country");
	private Address address1 = new Address("street", 9, "zip", "city", "country");;

	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer(firstName, lastName).setBirthDate(birthDate).add(address)
				.add(address1).setMailAddress(mailAddress).setRating(rating);
		Customer savedCustomer = dataAccessService.saveCustomer(customer);
		Assert.isTrue(savedCustomer.getMailAddress().equals(customer.getMailAddress()));
	}
}