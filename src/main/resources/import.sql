-- MailAddress
INSERT INTO `transaction`.`mail_address` (`id`, `mail_address`) VALUES(1, 'dummy@email.de');
INSERT INTO `transaction`.`mail_address` (`id`, `mail_address`) VALUES(2, 'dummy1@email.de');

-- Customer
INSERT INTO `transaction`.`customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES (1, CURRENT_DATE(), 'dummyFirstName', 'dummyLastName', 3, 1);
INSERT INTO `transaction`.`customer` (`id`, `birth_date`, `first_name`, `last_name`, `rating`, `mailAddress_id`) VALUES (2, CURRENT_DATE(), 'dummyFirstName1', 'dummyLastName1', 4, 2);

-- Address
INSERT INTO `transaction`.`address` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES (1, NULL, 'dummyCity', 'dummyCountry', 8, 'dummyZip', 'dummyStreet');
INSERT INTO `transaction`.`address` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES (2, NULL, 'dummyCity1', 'dummyCountry1', 9, 'dummyZip1', 'dummyStreet1');
INSERT INTO `transaction`.`address` (`id`, `additional_address_info`, `city`, `country`, `number`, `postal_code`, `street`) VALUES (3, NULL, 'dummyCity2', 'dummyCountry2', 21, 'dummyZip2', 'dummyStreet2');

-- Customer Address
INSERT INTO `transaction`.`customer_address` (`customer_id`, `addressList_id`) VALUES (1, 1);
INSERT INTO `transaction`.`customer_address` (`customer_id`, `addressList_id`) VALUES (1, 2);
INSERT INTO `transaction`.`customer_address` (`customer_id`, `addressList_id`) VALUES (2, 3);

-- Ordering
INSERT INTO `transaction`.`ordering` (`id`, `order_date`, `discount`, `customer_id`) VALUES (1, CURRENT_DATE(), 2, 1);
INSERT INTO `transaction`.`ordering` (`id`, `order_date`, `discount`, `customer_id`) VALUES (2, CURRENT_DATE(), 2.5, 1);
INSERT INTO `transaction`.`ordering` (`id`, `order_date`, `discount`, `customer_id`) VALUES (3, CURRENT_DATE(), 12.99, 2); 
INSERT INTO `transaction`.`ordering` (`id`, `order_date`, `discount`, `customer_id`) VALUES (4, CURRENT_DATE(), 35, 2); 
INSERT INTO `transaction`.`ordering` (`id`, `order_date`, `discount`, `customer_id`) VALUES (5, CURRENT_DATE(), 7.50, 2);

-- ProductCategory
INSERT INTO `transaction`.`product_category` (`id`, `category`) VALUES (1, 'CLOTHES');
INSERT INTO `transaction`.`product_category` (`id`, `category`) VALUES (2, 'ELECTRONICS');
INSERT INTO `transaction`.`product_category` (`id`, `category`) VALUES (3, 'MISC');

-- Item
INSERT INTO `transaction`.`item` (`id`, `long_description`, `price`, `short_description`, `category_id`) VALUES (1, 'longDescription', '7.99', 'shortDescription', 1);
INSERT INTO `transaction`.`item` (`id`, `long_description`, `price`, `short_description`, `category_id`) VALUES (2, 'longDescription', '19.99', 'shortDescription', 2); 
INSERT INTO `transaction`.`item` (`id`, `long_description`, `price`, `short_description`, `category_id`) VALUES (3, 'longDescription', '35.99', 'shortDescription', 1); 
INSERT INTO `transaction`.`item` (`id`, `long_description`, `price`, `short_description`, `category_id`) VALUES (4, 'longDescription', '10', 'shortDescription', 2);
INSERT INTO `transaction`.`item` (`id`, `long_description`, `price`, `short_description`, `category_id`) VALUES (5, 'longDescription', '5', 'shortDescription', 3);

-- Ordering Item
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (1, 1);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (1, 2);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (1, 4);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (2, 3);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (2, 5);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (3, 5);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (4, 2);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (5, 4);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (5, 3);
INSERT INTO `transaction`.`ordering_item` (`ordering_id`, `items_id`) VALUES (5, 1);

