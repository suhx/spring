package org.spring.transaction.repository;

import org.spring.transaction.data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findById(Long id);
}