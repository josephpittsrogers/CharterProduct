package com.charter.product.service;

public interface ProductService {
	public Boolean isDiscounted(String productId);
	public String getAllProducts();
	public String quantitySoldByProductType();
}
