package org.spring.transaction.service;

import org.spring.transaction.data.Customer;

public interface DataAccessService {

	public Customer findCustomerById(Long id);

	public Customer saveCustomer(Customer customer);
}