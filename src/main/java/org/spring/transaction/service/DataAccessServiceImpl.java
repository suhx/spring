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
	public Customer findCustomerById(final Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer saveCustomer(final Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(final Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * Ordering Queries
	 */

	@Override
	public List<Ordering> findOrderingByCustomer(final Customer customer) {
		return orderingRepository.findByCustomer(customer);
	}

	@Override
	public List<Ordering> findOrderingByDateLessThan(final LocalDate date) {
		return orderingRepository.findByDateLessThan(date);
	}

	@Override
	public List<Ordering> findOrderingByDateGreaterThan(final LocalDate date) {
		return orderingRepository.findByDateGreaterThan(date);
	}

	@Override
	public List<Ordering> findOrderingByDate(final LocalDate date) {
		return orderingRepository.findByDate(date);
	}

	/**
	 * Item Queries
	 */

	@Override
	public List<Item> findItemByCategory(final ProductCategory category) {
		return itemRepository.findByCategory(category);
	}

	@Override
	public List<Item> findItemByPriceGreaterThan(final BigDecimal price) {
		return itemRepository.findByPriceGreaterThan(price);
	}

	@Override
	public List<Item> findItemByPriceLessThan(final BigDecimal price) {
		return itemRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Item> findItemByPrice(final BigDecimal price) {
		return itemRepository.findByPrice(price);
	}

	@Override
	public List<Item> findItemByShortDescriptionContaining(final String shortDescription) {
		return itemRepository.findByShortDescriptionContaining(shortDescription);
	}

	/**
	 * ProductCategory Queries
	 */

	@Override
	public ProductCategory saveProductCategory(final ProductCategory category) {
		return productCategoryRepository.save(category);
	}

	@Override
	public ProductCategory findProductCategoryById(final Long id) {
		return productCategoryRepository.findById(id);
	}
}