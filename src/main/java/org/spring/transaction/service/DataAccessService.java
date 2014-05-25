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

	/**
	 * Automatische Kundensuche nach gekauftem Artikel ging nicht. Dazu wurde
	 * einen Logik Methode implementiert
	 * 
	 */
	// public List<Customer> findCustomersByBoughtItem(Item item);

	public void deleteCustomer(Customer customer);

	/**
	 * Ordering
	 */

	public Ordering saveOrdering(Ordering ordering);

	public List<Ordering> findOrderingsByOrderDateLessThan(LocalDate orderDate);

	public List<Ordering> findOrderingsByOrderDateGreaterThan(LocalDate orderDate);

	public List<Ordering> findOrderingsByOrderDate(LocalDate orderDate);

	public List<Ordering> findOrderingsByCustomer(Customer customer);

	public List<Ordering> findOrderingsByItems(List<Item> itemList);

	public List<Ordering> findOrderings();

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