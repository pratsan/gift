package com.star.gift.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.star.gift.dto.ResponseDto;
import com.star.gift.exception.OrderNotFoundException;
import com.star.gift.service.OrderService;
import com.star.gift.utility.ErrorConstants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderControllerTest {
	@InjectMocks
	OrderController orderController;
	@Mock
	OrderService orderService;
	ResponseDto responseDto=new ResponseDto();
	@Before
	public void init()
	{
		responseDto.setStatusCode(ErrorConstants.ORDER_PLACED_SUCCESS_CODE);
		responseDto.setStatusMessage(ErrorConstants.ORDER_PLACED_SUCCESS);
		
	}
	@Test
	public void orderTest() throws OrderNotFoundException
	{
		Mockito.when(orderService.makePayment(1L)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> actual=orderController.PaceOrder("1");
		assertEquals(HttpStatus.ACCEPTED, actual.getStatusCode());
	}
	

}
