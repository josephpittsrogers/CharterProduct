package com.charter.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.charter.product.service.ProductService;


@RestController
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
/*
 *   The purpose of this end point is to display whether or not the product is discounted 
 */
    @GetMapping(path="/isDiscounted/{productId}", produces = "text/html")
   @ResponseBody
   public String isDiscounted(@PathVariable("productId") String productId){
	   return productService.isDiscounted(productId).toString();
   }    
   
/*
 *   The purpose of this end point is to display a list of the product identifiers along with the product
 *   cost.  If the product is discounted the cost is displayed between parentheses. 
 */
  @GetMapping(path="/all", produces = "text/html")
  @ResponseBody
  public String getAllProducts() {
	  return productService.getAllProducts();
  }
  
/*
 *   The purpose of this end point is to display a list of the product types along with the product
 *   sold totals for that product type. 
 */
 @GetMapping(path="/typeTally", produces = "text/html")
 @ResponseBody
 public String quantitySoldByProductType() {
	  return productService.quantitySoldByProductType();
 }    
}