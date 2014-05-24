package org.spring.transaction.repository;

import org.spring.transaction.data.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

	ProductCategory findById(Long id);

}