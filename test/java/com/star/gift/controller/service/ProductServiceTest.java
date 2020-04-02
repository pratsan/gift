package com.star.gift.controller.service;

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

import com.star.gift.dto.ProductDto;
import com.star.gift.entity.Product;
import com.star.gift.exception.ProductException;
import com.star.gift.service.ProductServiceImpl;
import com.star.gift.service.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	@InjectMocks
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
}

@Test
public void productFoundTest() throws ProductException
{
Mockito.when(productRepository.findAll()).thenReturn(productList);
List<ProductDto> actual=productServiceImpl.getAllProduct();
assertEquals(1, actual.size());
}

@Test(expected = ProductException.class)
public void productNotFoundTest() throws ProductException
{
	List<Product> products=new ArrayList<>();
Mockito.when(productRepository.findAll()).thenReturn(products);
List<ProductDto> actual=productServiceImpl.getAllProduct();
assertEquals(1, actual.size());
}
}
