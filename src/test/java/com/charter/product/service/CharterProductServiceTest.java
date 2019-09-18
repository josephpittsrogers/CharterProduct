package com.charter.product.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.charter.product.model.Product;
import com.charter.product.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class CharterProductServiceTest {
	Product product1 = new Product();
	Product product2 = new Product();
	List<Product> products = new ArrayList<>();

	
    @InjectMocks
    ProductServiceImpl productService;
     
    @Mock
    ProductRepository productRepository;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
		product1.setProductDiscounted(true);
		product1.setProductId("product1");
		product1.setId(1);
		product1.setProductCost(new BigDecimal(100));
		product1.setProductType("type1");
		product1.setProductSoldCt(1000);
		product2.setProductDiscounted(false);
		product2.setProductId("product2");
		product2.setId(2);
		product2.setProductCost(new BigDecimal(150));
		product2.setProductType("type2");
		product2.setProductSoldCt(1500);
		products.add(product1);
		products.add(product2);
    }

	@Test
	public void testIsDiscounted() {
		when(productRepository.findByProductId("product1")).thenReturn(product1);
		Boolean discounted = productService.isDiscounted("product1");
		assertTrue(discounted.booleanValue() == true);
	}

	@Test
	public void testGetAllProducts() {
		when(productRepository.findAll()).thenReturn(products);
		String textList = productService.getAllProducts();
		assertTrue(textList.contains("product1"));
		assertTrue(textList.contains("product2"));
		assertTrue(textList.contains("100"));
		assertTrue(textList.contains("150"));
	}
	@Test
	public void testQuantitySoldByProductType() {
		when(productRepository.findAll()).thenReturn(products);
		String textList = productService.quantitySoldByProductType();
		assertTrue(textList.contains("type1"));
		assertTrue(textList.contains("type2"));
		assertTrue(textList.contains("1000"));
		assertTrue(textList.contains("1500"));
	}

}
