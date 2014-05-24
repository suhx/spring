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
	private String firstName1 = "firstName1";
	private String lastName = "lastName";
	private Date birthDate = new Date();
	private MailAddress mailAddress = new MailAddress("test@test.de");
	private int rating = 8;
	private Address address = new Address("street", 8, "zip", "city", "country");
	private Address address1 = new Address("street", 9, "zip", "city", "country");

	// @Before
	// public void before() {
	// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	// ctx.load("classpath:spring/applicationContext.xml");
	// }

	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer(firstName, lastName).setBirthDate(birthDate).add(address)
				.add(address1).setMailAddress(mailAddress).setRating(rating);
		Customer savedCustomer = dataAccessService.saveCustomer(customer);
		Customer foundCustomer = dataAccessService.findCustomerById(savedCustomer.getId());
		Assert.isTrue(foundCustomer.getMailAddress().equals(customer.getMailAddress()));
	}

	@Test
	public void updateCustomerTest() {
		Customer customer = new Customer(firstName, lastName).setBirthDate(birthDate).add(address)
				.setMailAddress(mailAddress).setRating(rating);
		Customer savedCustomer = dataAccessService.saveCustomer(customer);
		savedCustomer.setFirstName(firstName1);
		Customer updatedCustomer = dataAccessService.updateCustomer(savedCustomer);
		Customer foundCustomer = dataAccessService.findCustomerById(updatedCustomer.getId());
		Assert.isTrue(foundCustomer.getFirstName().equals(updatedCustomer.getFirstName()));
		Assert.isTrue(savedCustomer.getId().equals(foundCustomer.getId()));
	}
}