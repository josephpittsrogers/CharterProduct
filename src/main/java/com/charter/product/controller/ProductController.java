package com.charter.product.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.charter.product.service.ProductService;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
/*
 *   The purpose of this end point is to display whether or not the product is discounted 
 */
   @GetMapping(path="/isDiscounted/{productId}", produces = "text/html")
   @ResponseBody
	   public String isDiscounted(@PathVariable("productId") String productId){
	       String rtn = null;
	       Boolean boolRtn = productService.isDiscounted(productId);
	       if (boolRtn == null) {
	    	   rtn = "Product Id: " + productId + " not returned";
	       } else {
	    	   rtn = boolRtn.toString();
	       }
		   return rtn;
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
 
 @ExceptionHandler(IOException.class)
 public ModelAndView handleIOException(IOException ex) {
	 logger.error("Controller IOError" + ex.getMessage());
     ModelAndView model = new ModelAndView("Controller IOError");
  
     model.addObject("exception", ex.getMessage());
  
     return model;
 }
}