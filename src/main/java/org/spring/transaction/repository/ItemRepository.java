package org.spring.transaction.repository;

import org.spring.transaction.data.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}