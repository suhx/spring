package org.spring.transaction.repository;

import java.util.List;

import org.spring.transaction.data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findById(Long id);

	public List<Customer> findByRatingGreaterThan(Integer rating);

	public List<Customer> findByRating(Integer rating);

	public List<Customer> findByRatingLessThan(Integer rating);

}