package com.charter.product.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "product_id")
	private String productId;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "product_cost")
	private BigDecimal productCost;
	@Column(name = "product_sold_ct")
	private Integer productSoldCt;
	@Column(name = "product_discounted")
	private Boolean productDiscounted;
}
