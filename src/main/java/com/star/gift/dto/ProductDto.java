package com.star.gift.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	private String ProductName;
	private String productDescription;
	private Double productPrice;
	private String productCode;
	private int quantity;
}
