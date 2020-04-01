package com.star.gift.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.gift.dto.ProductDto;
import com.star.gift.entity.Product;
import com.star.gift.exception.ProductException;
import com.star.gift.service.repository.ProductRepository;
import com.star.gift.utility.ErrorConstants;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
ProductRepository productRepository;
	@Override
	public List<ProductDto> getAllProduct() throws ProductException {
		List<Product> products=productRepository.findAll();
		if(products.isEmpty())
			throw new ProductException(ErrorConstants.NO_RECORD_FOUND);
		
		return products.stream().map(product->{
			ProductDto productDto=new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			return productDto;
		}).collect(Collectors.toList());
	}

}
