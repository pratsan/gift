package com.star.gift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.gift.dto.ResponseDto;
import com.star.gift.exception.OrderNotFoundException;
import com.star.gift.service.MailServiceImpl;
import com.star.gift.service.OrderService;

@RestController
@RequestMapping("products/")
public class OrderController {
@Autowired
MailServiceImpl mailServiceImpl;
@Autowired
OrderService orderService;
	@PutMapping("{cartId}")
	public ResponseEntity<ResponseDto> PaceOrder(@PathVariable("cartId") String cartId) throws NumberFormatException, OrderNotFoundException
	{
		return new ResponseEntity<>(orderService.makePayment(Long.parseLong(cartId)),HttpStatus.ACCEPTED);
	}
}
