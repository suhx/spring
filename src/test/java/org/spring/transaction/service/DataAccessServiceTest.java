package org.spring.transaction.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.transaction.data.Address;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.MailAddress;
import org.spring.transaction.data.Ordering;
import org.spring.transaction.data.ProductCategory;
import org.spring.transaction.enumeration.ProductCategoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DataAccessServiceTest {

	@Autowired
	private DataAccessService dataAccessService;

	private String mailAddressString = "test@test.de";
	private String mailAddressString1 = "test1@test1.de";
	private String firstName = "firstName";
	private String firstName1 = "firstName1";
	private String lastName = "lastName";
	private Date birthDate = new Date();
	private Integer rating = 8;
	private Address address;
	private Address address1;
	private MailAddress mailAddress;
	private MailAddress mailAddress1;
	private Customer customer;
	private Customer customer1;
	private ProductCategory category;
	private ProductCategoryEnum categoryEnumClothes;
	private ProductCategoryEnum categoryEnumMisc;
	private ProductCategoryEnum categoryEnumElectronis;

	@Before
	public void beforeTest() {
		this.mailAddress = new MailAddress(mailAddressString);
		this.mailAddress1 = new MailAddress(mailAddressString1);
		this.address = new Address("street", 8, "zip", "city", "country");
		this.address1 = new Address("street", 9, "zip", "city", "country");
		this.customer = new Customer(firstName, lastName).setBirthDate(birthDate).addAddress(address)
				.addAddress(address1).setMailAddress(mailAddress).setRating(rating);
		this.customer1 = new Customer(firstName, lastName).setBirthDate(birthDate).addAddress(address)
				.setMailAddress(mailAddress1).setRating(rating);
		this.categoryEnumClothes = ProductCategoryEnum.CLOTHES;
		this.categoryEnumElectronis = ProductCategoryEnum.ELECTRONICS;
		this.categoryEnumMisc = ProductCategoryEnum.MISC;
		this.category = new ProductCategory(categoryEnumClothes);
	}

	@Test
	public void testSaveCustomer() {
		Customer savedCustomer = dataAccessService.saveCustomer(this.customer);
		Customer foundCustomer = dataAccessService.findCustomerById(savedCustomer.getId());
		Assert.isTrue(foundCustomer.getMailAddress().equals(customer.getMailAddress()));
		Assert.isTrue(foundCustomer.getAddresseList().size() == 2);
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

	@Test
	public void testFindOrderingsByCustomer() {
		Customer foundCustomer = dataAccessService.findCustomerById(1L);
		List<Ordering> orderingList = dataAccessService.findOrderingsByCustomer(foundCustomer);
	}
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
