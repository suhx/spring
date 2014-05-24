package org.spring.transaction.repository;

import java.util.List;

import org.spring.transaction.data.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findById(Long id);

	@Query("select c from Customer c where rating > :rating")
	public List<Customer> findByGreaterThanRating(@Param("rating") Integer rating);

	@Query("select c from Customer c where rating = :rating")
	public List<Customer> findByEqualsRating(Integer rating);

	@Query("select c from Customer c where rating < :rating")
	public List<Customer> findByLowerThanRating(Integer rating);

}