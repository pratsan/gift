package com.star.gift.service;

import java.util.List;

import com.star.gift.dto.ProductDto;
import com.star.gift.exception.ProductException;

public interface ProductService {
	public List<ProductDto> getAllProduct() throws ProductException;

}
