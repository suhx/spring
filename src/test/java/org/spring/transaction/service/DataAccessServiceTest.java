package org.spring.transaction.service;

import java.util.Date;

import org.junit.Before;
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
	private MailAddress mailAddress1 = new MailAddress("test1@test1.de");
	private Integer rating = 8;
	private Address address = new Address("street", 8, "zip", "city", "country");
	private Address address1 = new Address("street", 9, "zip", "city", "country");
	private Customer customer;
	private Customer customer1;

	@Before
	public void beforeClass() {
		this.customer = new Customer(firstName, lastName).setBirthDate(birthDate).add(address).add(address1)
				.setMailAddress(mailAddress).setRating(rating);
		this.customer1 = new Customer(firstName, lastName).setBirthDate(birthDate).add(address)
				.setMailAddress(mailAddress1).setRating(rating);
	}

	@Test
	public void testSaveCustomer() {
		Customer savedCustomer = dataAccessService.saveCustomer(this.customer);
		Customer foundCustomer = dataAccessService.findCustomerById(savedCustomer.getId());
		Assert.isTrue(foundCustomer.getMailAddress().equals(customer.getMailAddress()));
		Assert.isTrue(foundCustomer.getAddresses().size() == 2);
	}

	@Test
	public void testUpdateCustomer() {
		Customer savedCustomer = dataAccessService.saveCustomer(this.customer1);
		savedCustomer.setFirstName(firstName1);
		Customer updatedCustomer = dataAccessService.updateCustomer(savedCustomer);
		Customer foundCustomer = dataAccessService.findCustomerById(updatedCustomer.getId());
		Assert.isTrue(foundCustomer.getFirstName().equals(updatedCustomer.getFirstName()));
		Assert.isTrue(savedCustomer.getId().equals(foundCustomer.getId()));
	}
	//
	// @Test
	// public void testFindOrderingByCustomer() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindOrderingByDateLessThan() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindOrderingByDateGreaterThan() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindOrderingByDate() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindItemByCategory() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindItemByPriceGreaterThan() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindItemByPriceLessThan() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindItemByPrice() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFindItemByShortDescriptionContaining() {
	// fail("Not yet implemented");
	// }
}
