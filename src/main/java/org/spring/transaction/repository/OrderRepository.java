package org.spring.transaction.repository;

import java.util.List;

import org.joda.time.LocalDate;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	public List<Order> findByCustomer(Customer customer);

	public List<Order> findByDateLowerThan(LocalDate date);

}