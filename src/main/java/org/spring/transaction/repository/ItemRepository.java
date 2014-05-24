package org.spring.transaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.spring.transaction.data.Item;
import org.spring.transaction.data.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	public List<Item> findByCategory(ProductCategory category);

	public List<Item> findByPriceLessThan(BigDecimal price);

	public List<Item> findByPrice(BigDecimal price);

	public List<Item> findByPriceGreaterThan(BigDecimal price);

	public List<Item> findByShortDescriptionContaining(String shortDescription);
}