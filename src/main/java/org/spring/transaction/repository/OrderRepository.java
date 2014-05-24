package org.spring.transaction.repository;

import org.spring.transaction.data.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}