package org.spring.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Item;
import org.spring.transaction.data.Ordering;
import org.spring.transaction.data.ProductCategory;

public interface DataAccessService {

	/**
	 * Customer
	 */

	public Customer findCustomerById(Long id);

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	/**
	 * Ordering
	 */

	public List<Ordering> findOrderingByDateLessThan(LocalDate date);

	public List<Ordering> findOrderingByDateGreaterThan(LocalDate date);

	public List<Ordering> findOrderingByDate(LocalDate date);

	public List<Ordering> findOrderingByCustomer(Customer customer);

	/**
	 * Item
	 */

	public List<Item> findItemByCategory(ProductCategory category);

	public List<Item> findItemByPriceGreaterThan(BigDecimal price);

	public List<Item> findItemByPriceLessThan(BigDecimal price);

	public List<Item> findItemByPrice(BigDecimal price);

	public List<Item> findItemByShortDescriptionContaining(String shortDescription);

	/**
	 * ProductCategory
	 */

	public ProductCategory saveProductCategory(ProductCategory category);

	public ProductCategory findProductCategoryById(Long id);

}