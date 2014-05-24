package org.spring.transaction.logic;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionLogicTest {

	@Autowired
	private TransactionLogic transactionLogic;

	@Ignore
	@Test
	public void saveObjectsTrueTest() {
		transactionLogic.saveObjects(true);
	}

	@Ignore
	@Test
	public void saveObjectsFalseTest() {
		transactionLogic.saveObjects(false);
	}

	@Ignore
	@Test
	public void saveObjects() {
		transactionLogic.saveObjects();
	}
}