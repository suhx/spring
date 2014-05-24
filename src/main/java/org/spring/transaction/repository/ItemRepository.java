package org.spring.transaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.spring.transaction.data.Item;
import org.spring.transaction.data.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	List<Item> findByCategory(ProductCategory category);

	List<Item> findByPriceLessThan(BigDecimal price);

	List<Item> findByPrice(BigDecimal price);

	List<Item> findByPriceGreaterThan(BigDecimal price);

	List<Item> findByShortDescriptionContaining(String shortDescription);
}