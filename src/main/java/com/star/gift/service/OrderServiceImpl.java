package com.star.gift.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.gift.dto.MailDto;
import com.star.gift.dto.ResponseDto;
import com.star.gift.entity.Cart;
import com.star.gift.entity.Customer;
import com.star.gift.entity.User;
import com.star.gift.exception.OrderNotFoundException;
import com.star.gift.service.repository.CartRepository;
import com.star.gift.utility.ErrorConstants;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired
CartRepository cartRepository;
@Autowired
MailService mailService; 
	@Override
	public ResponseDto makePayment(Long cartId) throws OrderNotFoundException {
		List<MailDto> mailList=new ArrayList<>();
		
		Optional<Cart> cart=cartRepository.findById(cartId);
		if(!cart.isPresent())
			throw new OrderNotFoundException(ErrorConstants.ORDER_NOT_FOUND);
		List<User> user=cart.get().getUser();
		if(user.isEmpty())
			throw new OrderNotFoundException(ErrorConstants.ORDER_NOT_FOUND);
	   Customer customer=cart.get().getCustomer();
		user.forEach(userEmail->{
			if(userEmail.getCartId().equals(cartId) && !cart.get().isFlag())
			{
				MailDto mailDto=new MailDto();
				mailDto.setEmail(userEmail.getEmail());
				mailDto.setMessage(userEmail.getMessage());
				mailList.add(mailDto);
				
		}
		});
		
		
		
		
		if(mailList.isEmpty())
			throw new OrderNotFoundException(ErrorConstants.PURCHASED);
		
		String message=mailService.sendMail(mailList,customer.getCustomerEmail());
		System.out.println(message);
		ResponseDto dto=new ResponseDto();
		if(message.equals("order placed successfully"))
		{
			cart.get().setFlag(true);
			cartRepository.save(cart.get());
			
			dto.setStatusMessage(ErrorConstants.ORDER_PLACED_SUCCESS);
			dto.setStatusCode(ErrorConstants.ORDER_PLACED_SUCCESS_CODE);
			return dto;
		}
		dto.setStatusCode(ErrorConstants.ORDER_PLACED_FAIL_CODE);
		dto.setStatusMessage(ErrorConstants.ORDER_PLACED_FAIL);
		
	return dto;
	
	}

}
