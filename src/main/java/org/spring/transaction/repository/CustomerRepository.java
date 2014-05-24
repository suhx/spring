package org.spring.transaction.repository;

import java.util.List;

import org.spring.transaction.data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findById(Long id);

	List<Customer> findByRatingGreaterThan(Integer rating);

	List<Customer> findByRating(Integer rating);

	List<Customer> findByRatingLessThan(Integer rating);

}