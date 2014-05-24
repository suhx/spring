package org.spring.transaction.logic;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionLogicTest {

	@Autowired
	private TransactionLogic transactionLogic;

	@Test
	public void saveObjectsTrueTest() {
		transactionLogic.saveObjects(true);
	}

	@Test
	public void saveObjectsFalseTest() {
		transactionLogic.saveObjects(false);
	}

	@Test
	public void saveObjects() {
		transactionLogic.saveObjects();
	}
}