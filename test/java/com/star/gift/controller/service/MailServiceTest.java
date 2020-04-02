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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.star.gift.dto.MailDto;
import com.star.gift.service.MailServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)
public class MailServiceTest {
	@InjectMocks
	MailServiceImpl mailServiceImpl;
	@Mock
	JavaMailSender javaMailSender;
	@Mock
	SimpleMailMessage simpleMailMessage;
	
	MailDto mail=new MailDto();
	List<MailDto> mails=new ArrayList<MailDto>();
	@Before
	public void init()
	{
		mail.setEmail("pratsan02@gmail.com");
		mail.setMessage("gift");
		mail.setName("prateek");
		
		mails.add(mail);
	}
	
	@Test
	public void testMail()
	{
  String s=mailServiceImpl.sendMail(mails,"prateek.pal@hcl.com");
  assertEquals("order placed successfully", s);
	}
	
	@Test
	public void InvalidMail()
	{
		List<MailDto> mailList=null;//=new ArrayList<MailDto>();
  String s=mailServiceImpl.sendMail(mailList,"prateek@gmail.com");
  assertEquals("sorry can't place order", s);
	}
	
	
}
