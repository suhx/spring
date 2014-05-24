package org.spring.transaction.repository;

import java.util.List;

import org.spring.transaction.data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findById(Long id);

	public List<Customer> findByRatingGreaterThan(int rating);

	public List<Customer> findByRatingEquals(int rating);

	public List<Customer> findByRatingLowerThan(int rating);
}