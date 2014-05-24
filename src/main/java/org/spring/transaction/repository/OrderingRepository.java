package org.spring.transaction.repository;

import java.util.List;

import org.joda.time.LocalDate;
import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Ordering;
import org.springframework.data.repository.CrudRepository;

public interface OrderingRepository extends CrudRepository<Ordering, Long> {

	List<Ordering> findByCustomer(Customer customer);

	List<Ordering> findByDateLessThan(LocalDate date);

	List<Ordering> findByDateGreaterThan(LocalDate date);

	List<Ordering> findByDate(LocalDate date);

}