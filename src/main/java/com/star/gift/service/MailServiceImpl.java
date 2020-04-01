package com.star.gift.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.star.gift.dto.MailDto;

@Component
@Service
public class MailServiceImpl implements MailService{

	
	
	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	SimpleMailMessage simpleMailMessage;
	
	public String mail()
	{
		List<String> s=new ArrayList<>();
		s.add("pal");
		s.add("kol");
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setText("pal");
		simpleMailMessage.setTo("prateek.pal@hcl.com");
		//simpleMailMessage.setTo(to);
		
		simpleMailMessage.setTo(Arrays.asList(s).toString());
		
		javaMailSender.send(simpleMailMessage);
		return "success";
	}

	@Override
	public String sendMail(List<MailDto> mailList,String email) {
		String message="order placed successfully";
		try {
		mailList.forEach(user->{
			simpleMailMessage.setText("dear,"+user.getMessage());
			simpleMailMessage.setTo(user.getEmail());
			simpleMailMessage.setBcc(email);
		javaMailSender.send(simpleMailMessage);
		});
		
		}
		catch(Exception e)
		{
		message="sorry can't place order";
		}
		return message;
	}
}
