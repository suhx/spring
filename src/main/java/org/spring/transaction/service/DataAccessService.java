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

	public List<Ordering> findOrderingsByDateLessThan(LocalDate date);

	public List<Ordering> findOrderingsByDateGreaterThan(LocalDate date);

	public List<Ordering> findOrderingsByDate(LocalDate date);

	public List<Ordering> findOrderingsByCustomer(Customer customer);

	/**
	 * Item
	 */

	public List<Item> findItemsByCategory(ProductCategory category);

	public List<Item> findItemsByPriceGreaterThan(BigDecimal price);

	public List<Item> findItemsByPriceLessThan(BigDecimal price);

	public List<Item> findItemsByPrice(BigDecimal price);

	public List<Item> findItemsByShortDescriptionContaining(String shortDescription);

	/**
	 * ProductCategory
	 */

	public ProductCategory saveProductCategory(ProductCategory category);

	public ProductCategory findProductCategoryById(Long id);

}