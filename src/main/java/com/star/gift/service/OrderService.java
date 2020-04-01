package com.star.gift.service;

import com.star.gift.dto.ResponseDto;
import com.star.gift.exception.OrderNotFoundException;

public interface OrderService {
	public ResponseDto makePayment(Long cartId) throws OrderNotFoundException;
	

}
