package org.spring.transaction.service;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.MailAddress;
import org.spring.transaction.data.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DataAccessServiceTest {

	@Autowired
	private DataAccessService dataAccessService;

	private String firstName;
	private String firstName1;
	private String lastName;
	private LocalDate birthDate;
	private String mailAddressString;
	private MailAddress mailAddress;
	private Customer customer;

	@Before
	public void beforeTest() {
		this.firstName = "firstName";
		this.firstName1 = "firstName1";
		this.lastName = "lastName";
		this.birthDate = new LocalDate("1970-01-01");
		this.mailAddressString = "mail@mail.de";
		this.mailAddress = new MailAddress(this.mailAddressString);
		this.customer = new Customer(this.firstName, this.lastName);
		this.customer.setBirthDate(this.birthDate).setMailAddress(this.mailAddress);
	}

	@Test
	public void testSaveCustomer() {
		Assert.isNull(this.customer.getId());
		Customer savedCustomer = dataAccessService.saveCustomer(this.customer);
		Assert.isTrue(savedCustomer.getFirstName().equals(this.customer.getFirstName()));
		Assert.isTrue(savedCustomer.getLastName().equals(this.customer.getLastName()));
		Assert.isTrue(savedCustomer.getBirthDate().equals(this.customer.getBirthDate()));
		Assert.isTrue(savedCustomer.getMailAddress().equals(this.customer.getMailAddress()));
		dataAccessService.deleteCustomer(this.customer);
	}

	@Test
	public void testUpdateCustomer() {
		Assert.isNull(this.customer.getId());
		Customer savedCustomer = dataAccessService.saveCustomer(this.customer);
		Assert.isTrue(savedCustomer.getId() != null);
		Assert.isTrue(savedCustomer.getFirstName().equals(this.customer.getFirstName()));
		savedCustomer.setFirstName(firstName1);
		dataAccessService.saveCustomer(savedCustomer);
		Customer updatedCustomer = dataAccessService.findCustomerById(savedCustomer.getId());
		Assert.isTrue(updatedCustomer.getId().equals(savedCustomer.getId()));
		Assert.isTrue(updatedCustomer.getFirstName().equals(this.firstName1));
		dataAccessService.deleteCustomer(updatedCustomer);
	}

	@Test
	public void testFindOrderingsByCustomer() {
		Customer foundCustomer = dataAccessService.findCustomerById(1L);
		List<Ordering> orderingList = dataAccessService.findOrderingsByCustomer(foundCustomer);
		Assert.isTrue(orderingList.size() > 0);
		for (Ordering ordering : orderingList) {
			Assert.isTrue(ordering.getCustomer().getId().equals(foundCustomer.getId()));
		}
	}
}
