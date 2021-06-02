package com.mustafa.hmrs.core.utilities.validation;

import org.springframework.stereotype.Service;

@Service
public class SendMailManager implements SendMailService {
	
	@Override
	public boolean sendMail(String fromEmail, String toEmail, String subject, String message) {
		
		return true;
	}
}
