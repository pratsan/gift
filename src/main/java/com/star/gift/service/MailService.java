package com.star.gift.service;

import java.util.List;

import com.star.gift.dto.MailDto;

public interface MailService {
	public String sendMail(List<MailDto> mailDto,String email);

}
