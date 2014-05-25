package org.spring.transaction.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Item;
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

	private String firstName;
	private String firstName1;
	private String lastName;
	private LocalDate birthDate;
	private String mailAddressString;
	private MailAddress mailAddress;
	private Customer customer;
	private Ordering ordering;
	private List<Item> itemList;
	private Item item;
	private Item item1;
	private ProductCategoryEnum categoryEnumClothes;
	private ProductCategoryEnum categoryEnumMisc;
	private ProductCategory category;
	private ProductCategory category1;
	private String shortDescription;
	private String longDescription;
	private BigDecimal price;

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
		this.categoryEnumClothes = ProductCategoryEnum.CLOTHES;
		this.categoryEnumMisc = ProductCategoryEnum.MISC;
		this.category = new ProductCategory(this.categoryEnumClothes);
		this.category1 = new ProductCategory(this.categoryEnumMisc);
		this.shortDescription = "shortDescription";
		this.longDescription = "longDescription";
		this.price = new BigDecimal(5.99);
		this.item = new Item(this.category, this.shortDescription, this.longDescription, this.price);
		this.item1 = new Item(this.category1, this.shortDescription + "1", this.longDescription + "1",
				this.price.add(this.price));
		this.itemList = Arrays.asList(this.item, this.item1);
		this.ordering = new Ordering(this.customer, this.itemList);
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
