package org.spring.transaction.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.spring.transaction.data.Customer;
import org.spring.transaction.data.Item;
import org.spring.transaction.data.Ordering;
import org.spring.transaction.enumeration.OrderEnum;
import org.spring.transaction.service.DataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionLogic {

	@Autowired
	DataAccessService dataAccessService;

	/**
	 * Gibt alle Bestellungen aus, die den gewünschten Artikel beinhalten. Es
	 * werden die Kunden der Bestellung zurückgegeben
	 * 
	 * @param item
	 * @return List<Customer>
	 * 
	 */
	public List<Customer> getCustomersByBoughtItem(final Item item) {
		List<Item> itemList = Arrays.asList(item);
		List<Ordering> orderingList = dataAccessService.findOrderingsByItems(itemList);
		List<Customer> customerList = new ArrayList<Customer>();
		if (orderingList.size() > 0) {
			for (Ordering ordering : orderingList) {
				customerList.add(ordering.getCustomer());
			}
		}
		return customerList;
	}

	/**
	 * Summiert den Preis aller gekauften Items in einer Bestellung und schaut,
	 * ob die Summe größer/kleiner als der angegebene Wert ist Gibt alle Kunden
	 * zurück, die diese Bedingung erfüllen Implizit werden hier auch alle
	 * Bestellungen mit einem bestimmten Volumen ausgegeben bzw. berechnet.
	 * 
	 * @param salesVolume
	 * @param orderEnum
	 * @return List<Customer>
	 * 
	 */
	public List<Customer> getCustomersBySalesVolume(final BigDecimal salesVolume, final OrderEnum orderEnum) {
		List<Customer> customerList = new ArrayList<Customer>();
		List<Ordering> orderingList = dataAccessService.findOrderings();
		for (Ordering ordering : orderingList) {
			BigDecimal sum = new BigDecimal(0);
			for (Item item : ordering.getItems()) {
				sum = sum.add(item.getPrice());
			}
			if (orderEnum.getOrder().equals("greater") && sum.compareTo(salesVolume) == 1) {
				customerList.add(ordering.getCustomer());
			}
			if (orderEnum.getOrder().equals("lower") && sum.compareTo(salesVolume) == -1) {
				customerList.add(ordering.getCustomer());
			}
		}
		return customerList;
	}
}