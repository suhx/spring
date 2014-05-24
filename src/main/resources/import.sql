-- MailAddress
INSERT INTO `mail_address` (`id`, `value`) VALUES(1, 'dummy@email.de');
INSERT INTO `mail_address` (`id`, `value`) VALUES(2, 'dummy1@email.de');

-- Customer
INSERT INTO `customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES(1, CURDATE(), 'dummyFirstName', 'dummyLastName', 8, 1);
INSERT INTO `customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES(2, CURDATE(), 'dummyFirstName1', 'dummyLastName1', 8, 2);

-- Address
INSERT INTO `adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(1, NULL, 'dummyCity', 'dummyCountry', 8, 'dummyZip', 'dummyStreet');
INSERT INTO `adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(2, NULL, 'dummyCity1', 'dummyCountry1', 9, 'dummyZip1', 'dummyStreet1');
INSERT INTO `adress` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES(3, NULL, 'dummyCity2', 'dummyCountry2', 8, 'dummyZip2', 'dummyStreet2');

-- Customer Address
INSERT INTO `customer_adress` (`customer_id`, `addresses_id`) VALUES(1, 1);
INSERT INTO `customer_adress` (`customer_id`, `addresses_id`) VALUES(1, 2);
INSERT INTO `customer_adress` (`customer_id`, `addresses_id`) VALUES(2, 3);