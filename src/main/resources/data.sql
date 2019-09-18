DROP TABLE IF EXISTS product;
 
CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_id VARCHAR(25) NOT NULL,
  product_type VARCHAR(25) NOT NULL,
  product_cost DECIMAL NOT NULL,
  product_sold_ct INT NOT NULL,
  product_discounted INT NOT NULL
);
 
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product1', 'type1', 100.55, 150, true);
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product2', 'type1', 200.55, 250, false);
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product3', 'type1', 300.55, 350, true);
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product4', 'type2', 100.55, 100, false);
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product5', 'type2', 200.55, 200, true);
INSERT INTO product (product_id, product_type, product_cost, product_sold_ct, product_discounted) VALUES
  ('product6', 'type2', 300.55, 300, false);
  
  