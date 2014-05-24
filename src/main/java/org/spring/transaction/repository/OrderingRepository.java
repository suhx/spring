package org.spring.transaction.repository;

import java.util.List;

import org.joda.time.LocalDate;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Ordering;
import org.springframework.data.repository.CrudRepository;

public interface OrderingRepository extends CrudRepository<Ordering, Long> {

	public List<Ordering> findByCustomer(Customer customer);

	public List<Ordering> findByDateLessThan(LocalDate date);

	public List<Ordering> findByDateGreaterThan(LocalDate date);

	public List<Ordering> findByDate(LocalDate date);

}