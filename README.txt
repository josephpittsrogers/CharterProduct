The purpose of this web service is to display product information to consumers.

There are 3 types of queries
	1.	isDiscounted(productid) 
	2   getAllProducts()
	3	quantitySoldByProductType()
	
Once the spring boot project is deployed on the Tomcat server
there are three end points that are available

	1.	http://localhost:8082/product/isDiscounted/product1
		The result returned is either true or false in this case true.
		// 20190918094539
		// http://localhost:8082/product/isDiscounted/product1

		true
		There are six products that can be tested product1,2,3,4,5,6.
		The odd numbers will return true and the even ones false.
		
	2.	http://localhost:8082/product/all
		The return lists the products identifiers and the costs.
		If the product is discounted the cost is in parentheses.
		product1 | (100.55)
		product2 | 200.55
		product3 | (300.55)
		product4 | 100.55
		product5 | (200.55)
		product6 | 300.55
		
	3	http://localhost:8082/product/typeTally
		The return lists  the product types and the total amount sold.
		type1 : 750 (this is sum total)
		type2 : 600 (this is sum total)
		
The h2 data base that is used for this unit testing is defined in the src/main/resources/data.sql file;
The src/main/resources/application.properties file contains the h2 database configuration properties.

		
		