package org.spring.transaction.logic;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Item;
import org.spring.transaction.data.ProductCategory;
import org.spring.transaction.enumeration.OrderEnum;
import org.spring.transaction.enumeration.ProductCategoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionLogicTest {

	@Autowired
	private TransactionLogic transactionLogic;

	private Item item;
	private ProductCategory category;
	private String shortDescription;
	private String longDescription;
	private BigDecimal price;
	private ProductCategoryEnum categoryEnumClothes;
	private BigDecimal salesVolume;
	private OrderEnum orderEnum;

	@Before
	public void beforeTest() {
		this.categoryEnumClothes = ProductCategoryEnum.CLOTHES;
		this.category = new ProductCategory(this.categoryEnumClothes);
		this.shortDescription = "shortDescription";
		this.longDescription = "longDescription";
		this.price = new BigDecimal(5.99);
		this.item = new Item(this.category, this.shortDescription, this.longDescription, this.price);
		this.salesVolume = new BigDecimal(40);
		this.orderEnum = OrderEnum.GREATER;
	}

	@Ignore
	@Test
	public void testGetCustomersByBoughtItem() {
		this.item.setId(1l);
		List<Customer> customerList = transactionLogic.getCustomersByBoughtItem(this.item);
		Assert.isTrue(customerList.size() == 1);
		Assert.isTrue(customerList.get(0).getId().equals(2L));
	}

	@Ignore
	@Test
	public void testGetCustomersBySalesVolume() {
		List<Customer> customerList = transactionLogic.getCustomersBySalesVolume(this.salesVolume, this.orderEnum);
		Assert.isTrue(customerList.size() == 2);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testTransaction() {
		transactionLogic.transaction();
	}
}