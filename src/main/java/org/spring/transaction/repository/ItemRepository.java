package org.spring.transaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.spring.transaction.data.Item;
import org.spring.transaction.data.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Long> {

	public List<Item> findByCategory(ProductCategory category);

	@Query("select i from Item i where price < :price")
	public List<Item> findByLowerThanPrice(@Param("price") BigDecimal price);

	@Query("select i from Item i where price = :price")
	public List<Item> findByEqualsPrice(@Param("price") BigDecimal price);

	@Query("select i from Item i where price > :price")
	public List<Item> findByGreaterThanPrice(@Param("price") BigDecimal price);

	public List<Item> findByShortDescriptionLike(String shortDescription);
}