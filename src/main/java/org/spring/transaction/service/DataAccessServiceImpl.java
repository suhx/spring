package org.spring.transaction.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.spring.transaction.data.Customer;
import org.spring.transaction.repository.CustomerRepository;
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

	public Customer findCustomerById(final Long id) {
		return customerRepository.findById(id);
	}

	public Customer saveCustomer(final Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(final Customer customer) {
		return customerRepository.save(customer);
	}
}