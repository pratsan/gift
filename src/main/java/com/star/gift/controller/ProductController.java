package com.star.gift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.gift.dto.ProductDto;
import com.star.gift.exception.ProductException;
import com.star.gift.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService; 

public ResponseEntity<List<ProductDto>> getAllProducts() throws ProductException
{
	return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	
}
}
