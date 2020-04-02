package com.star.gift.controller.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.star.gift.dto.MailDto;
import com.star.gift.dto.ResponseDto;
import com.star.gift.entity.Cart;
import com.star.gift.entity.Customer;
import com.star.gift.entity.Product;
import com.star.gift.entity.User;
import com.star.gift.exception.OrderNotFoundException;
import com.star.gift.service.MailService;
import com.star.gift.service.OrderServiceImpl;
import com.star.gift.service.repository.CartRepository;
import com.star.gift.service.repository.OrderRepository;
import com.star.gift.utility.ErrorConstants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderServiceTest {
	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	ResponseDto responseDto=new ResponseDto();
	@Mock
	OrderRepository orderRepository;
	@Mock
	CartRepository cartRepository;
	
	MailService mailServiceImpl=Mockito.mock(MailService.class);
	
	@Mock
	JavaMailSender javaMailSender;
	@Mock
	SimpleMailMessage simpleMailMessage;
	
	Cart cart=new Cart();
	Customer customer=new Customer();
	Product product=new Product();
	User user=new User();
	List<User> users=new ArrayList<>();
	List<Cart> cartList=new ArrayList<Cart>();
	MailDto mail=new MailDto();
	List<MailDto> mails=new ArrayList<MailDto>();
	
	
@Before
public void init()
{
	mail.setEmail("pal@gmail.com");
	mail.setMessage("gift");
	mail.setName("prateek");
	
	mails.add(mail);
	responseDto.setStatusCode(ErrorConstants.ORDER_PLACED_SUCCESS_CODE);
	responseDto.setStatusMessage(ErrorConstants.ORDER_PLACED_SUCCESS);
	
	customer.setCustomerId(1L);
	customer.setCustomerEmail("prateek@gmail.com");
	customer.setCustomerName("prateek");
	customer.setPhoneNumber("1234");
	
	
	cart.setCartId(1L);
	cart.setFlag(false);
	cart.setPrice(200.0);
	cart.setQuantity(200);
	cart.setType("personal");
	cart.setProduct(product);
	cart.setCustomer(customer);
	cartList.add(cart);
	
	
	
	user.setCartId(1L);
	user.setEmail("pal@gmail.com");
	user.setMessage("gift");
	user.setUserId(1L);
	user.setUserName("prateek");
	users.add(user);
	
	product.setProductCode("A123");
	product.setProductDescription("gidt");
	product.setProductId(1L);
	product.setProductName("bat");
	product.setProductPrice(200.0);
	product.setQuantity(200);
	
	customer.setCartList(cartList);
	cart.setUser(users);
	customer.setCartList(cartList);
}

@Test(expected = Exception.class)
public void successOrder() throws OrderNotFoundException
{
	Mockito.when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
	
ResponseDto dto=orderServiceImpl.makePayment(1L);
assertEquals(603,dto.getStatusCode());
}

@Test(expected = OrderNotFoundException.class )
public void orderNotFoundTest() throws OrderNotFoundException
{
	Mockito.when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
	
	ResponseDto dto=orderServiceImpl.makePayment(10L);
}


@Test(expected = OrderNotFoundException.class )
public void userNotFoundTest() throws OrderNotFoundException
{
	List<User> userList=new ArrayList<>();
	Cart carts=new Cart();
	carts.setCartId(1L);
	carts.setFlag(false);
	carts.setPrice(200.0);
	carts.setQuantity(200);
	carts.setType("personal");
	carts.setProduct(product);
	carts.setCustomer(customer);
	carts.setUser(userList);

	Mockito.when(cartRepository.findById(1L)).thenReturn(Optional.of(carts));
	
	ResponseDto dto=orderServiceImpl.makePayment(1L);
}

}
