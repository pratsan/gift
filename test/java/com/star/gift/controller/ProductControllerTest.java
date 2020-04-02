package com.star.gift.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.star.gift.dto.ProductDto;
import com.star.gift.entity.Product;
import com.star.gift.exception.ProductException;
import com.star.gift.service.ProductServiceImpl;
import com.star.gift.service.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	@InjectMocks
	ProductController productController;
	@Mock
	ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepository productRepository;
	ProductDto productDto=new ProductDto();
	Product product=new Product();
	List<Product> productList=new ArrayList<>();
	List<ProductDto> productDtoList=new ArrayList<>();
	@Before
	public void init()
	{
		product.setProductCode("A123");
		product.setProductDescription("gift");
		product.setProductId(1L);
		product.setProductName("bat");
		product.setProductPrice(200.0);
		product.setQuantity(20);
		productList.add(product);
		
		
		productDto.setProductCode("A123");
		productDto.setProductDescription("gift");
		productDto.setProductName("bat");
		productDto.setProductPrice(200.0);
		productDto.setQuantity(20);
		productDtoList.add(productDto);
		
	}
	
	@Test
	public void ProductSuccessTest() throws ProductException
	{
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		ResponseEntity<List<ProductDto>> actual=productController.getAllProducts();
		assertEquals(HttpStatus.OK, actual.getStatusCode());
	}

}
