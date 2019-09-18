package com.charter.product.repository;
import com.charter.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
   
	public Product findByProductId(String productId);
	public Iterable<Product> findAll();
}
