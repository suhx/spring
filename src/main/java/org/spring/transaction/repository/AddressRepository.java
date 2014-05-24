package org.spring.transaction.repository;

import org.spring.transaction.data.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}