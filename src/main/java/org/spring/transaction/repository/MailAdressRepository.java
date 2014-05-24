package org.spring.transaction.repository;

import org.spring.transaction.data.MailAddress;
import org.springframework.data.repository.CrudRepository;

public interface MailAdressRepository extends CrudRepository<MailAddress, Long> {

}