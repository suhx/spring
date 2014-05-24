package org.spring.transaction.logic;

import org.spring.transaction.service.DataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionLogic {

	@Autowired
	DataAccessService dataAccessService;

	@Transactional
	public void saveObjects(final boolean success) {

	}

	public void saveObjects() {

	}
}