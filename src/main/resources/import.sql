-- MailAddress
INSERT INTO `transaction`.`mail_address` (`id`, `value`) VALUES(1, 'dummy@email.de');
INSERT INTO `transaction`.`mail_address` (`id`, `value`) VALUES(2, 'dummy1@email.de');

-- Customer
INSERT INTO `transaction`.`customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES(1, CURRENT_DATE(), 'dummyFirstName', 'dummyLastName', 8, 1);
INSERT INTO `transaction`.`customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES(2, CURRENT_DATE(), 'dummyFirstName1', 'dummyLastName1', 8, 2);

-- Address
INSERT INTO `transaction`.`adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(1, NULL, 'dummyCity', 'dummyCountry', 8, 'dummyZip', 'dummyStreet');
INSERT INTO `transaction`.`adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(2, NULL, 'dummyCity1', 'dummyCountry1', 9, 'dummyZip1', 'dummyStreet1');
INSERT INTO `transaction`.`adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(3, NULL, 'dummyCity2', 'dummyCountry2', 8, 'dummyZip2', 'dummyStreet2');

-- Customer Address
INSERT INTO `transaction`.`customer_adress` (`customer_id`, `addresses_id`) VALUES(1, 1);
INSERT INTO `transaction`.`customer_adress` (`customer_id`, `addresses_id`) VALUES(1, 2);
INSERT INTO `transaction`.`customer_adress` (`customer_id`, `addresses_id`) VALUES(2, 3);

-- Ordering
INSERT INTO `transaction`.`ordering` (`id`, `date`, `discount`, `customer_id`) VALUES (1, CURRENT_DATE(), '2', '1');
INSERT INTO `transaction`.`ordering` (`id`, `date`, `discount`, `customer_id`) VALUES (2, CURRENT_DATE(), '2,5', '1');
INSERT INTO `transaction`.`ordering` (`id`, `date`, `discount`, `customer_id`) VALUES (3, CURRENT_DATE(), '12,99', '2'); 
INSERT INTO `transaction`.`ordering` (`id`, `date`, `discount`, `customer_id`) VALUES (4, CURRENT_DATE(), '35', '2'); 
INSERT INTO `transaction`.`ordering` (`id`, `date`, `discount`, `customer_id`) VALUES (5, CURRENT_DATE(), '7,50', '2');

