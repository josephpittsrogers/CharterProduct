package com.charter.product.service;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.product.model.Product;
import com.charter.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	public static final String EMPTY_STRING = "";
	
	@Autowired
	private ProductRepository productRepository;

	public Boolean isDiscounted(String productId) {
		Product product = productRepository.findByProductId(productId);
		return product.getProductDiscounted();
	}
	
	public String getAllProducts() {
		StringBuilder rtn = new StringBuilder();
		Iterable<Product> products = productRepository.findAll();
		products.forEach(prod -> rtn.append(formatProduct(prod)));
		return rtn.toString();
		
	}
	
	private String formatProduct(Product prod) {
		StringBuilder sb = new StringBuilder();
		sb.append(prod.getProductId());
		sb.append(" | ");
		sb.append(prod.getProductDiscounted() ? "(" + prod.getProductCost() + ")" :  prod.getProductCost());
		sb.append("\r\n");
		return sb.toString();
	}
	
	public String quantitySoldByProductType() {
		StringBuilder sb = new StringBuilder(EMPTY_STRING);
		TreeMap<String, Integer> typeSold = new TreeMap<>();
		Iterable<Product> products = productRepository.findAll();
		products.forEach(prod -> tallyType(prod, typeSold));
		typeSold.forEach((prodtype, soldCt) -> displayTypeTotals(prodtype, soldCt, sb));
		if (sb.toString().equals(EMPTY_STRING)) {
			sb.append("NO PRODUCT TYPES FOUND");
		}
		return sb.toString();
	}

	private void tallyType(Product prod, TreeMap<String, Integer> typeSold) {
		Integer sold = typeSold.get(prod.getProductType());
		if (sold == null) {
			typeSold.put(prod.getProductType(), prod.getProductSoldCt());
		} else {
			typeSold.put(prod.getProductType(), sold + prod.getProductSoldCt());
		}
	}
	
	private String displayTypeTotals(String prodType, Integer soldCt, StringBuilder sb) {
		sb.append(prodType);
		sb.append(" : " );
		sb.append(soldCt);
		sb.append(" (this is sum total)");
		sb.append("\r\n");
		return sb.toString();
	}
	
}
