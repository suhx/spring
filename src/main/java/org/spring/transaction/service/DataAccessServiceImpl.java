package org.spring.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.LocalDate;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Item;
import org.spring.transaction.data.Ordering;
import org.spring.transaction.data.ProductCategory;
import org.spring.transaction.repository.CustomerRepository;
import org.spring.transaction.repository.ItemRepository;
import org.spring.transaction.repository.OrderingRepository;
import org.spring.transaction.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class DataAccessServiceImpl implements DataAccessService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderingRepository orderingRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	/**
	 * Customer Queries
	 */

	@Override
	public Customer findCustomerById(final Long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer saveCustomer(final Customer customer) {
		return customerRepository.save(customer);
	}

	// @Override
	// public List<Customer> findCustomersByBoughtItem(final Item item) {
	// List<Item> itemList = Arrays.asList(item);
	// TypedQuery<Customer> query = entityManager.createQuery(
	// "select distinct o.customer from Ordering o where o.items = ?",
	// Customer.class);
	// query.setParameter(1, itemList);
	// return query.getResultList();
	// }

	@Override
	public void deleteCustomer(final Customer customer) {
		customerRepository.delete(customer);
	}

	/**
	 * Ordering Queries
	 */

	@Override
	public List<Ordering> findOrderingsByCustomer(final Customer customer) {
		return orderingRepository.findByCustomer(customer);
	}

	@Override
	public List<Ordering> findOrderingsByOrderDateLessThan(final LocalDate orderDate) {
		return orderingRepository.findByOrderDateLessThan(orderDate);
	}

	@Override
	public List<Ordering> findOrderingsByOrderDateGreaterThan(final LocalDate orderDate) {
		return orderingRepository.findByOrderDateGreaterThan(orderDate);
	}

	@Override
	public List<Ordering> findOrderingsByOrderDate(final LocalDate orderDate) {
		return orderingRepository.findByOrderDate(orderDate);
	}

	@Override
	public List<Ordering> findOrderingsByItems(final List<Item> itemList) {
		return orderingRepository.findByItems(itemList);
	}

	@Override
	public Ordering saveOrdering(final Ordering ordering) {
		return orderingRepository.save(ordering);
	}

	@Override
	public List<Ordering> findOrderings() {
		return (List<Ordering>) orderingRepository.findAll();
	}

	/**
	 * Item Queries
	 */

	@Override
	public List<Item> findItemsByCategory(final ProductCategory category) {
		return itemRepository.findByCategory(category);
	}

	@Override
	public List<Item> findItemsByPriceGreaterThan(final BigDecimal price) {
		return itemRepository.findByPriceGreaterThan(price);
	}

	@Override
	public List<Item> findItemsByPriceLessThan(final BigDecimal price) {
		return itemRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Item> findItemsByPrice(final BigDecimal price) {
		return itemRepository.findByPrice(price);
	}

	@Override
	public List<Item> findItemsByShortDescriptionContaining(final String shortDescription) {
		return itemRepository.findByShortDescriptionContaining(shortDescription);
	}

	@Override
	public Item findItemById(final Long itemId) {
		return itemRepository.findOne(itemId);
	}

	@Override
	public void deleteItem(final Item item) {
		itemRepository.delete(item);
	}

	/**
	 * ProductCategory Queries
	 */

	@Override
	public ProductCategory saveProductCategory(final ProductCategory category) {
		return productCategoryRepository.save(category);
	}

	@Override
	public ProductCategory findProductCategoryById(final Long categoryId) {
		return productCategoryRepository.findById(categoryId);
	}
}