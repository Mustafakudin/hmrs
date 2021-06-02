package com.mustafa.hmrs.core.utilities.validation;

public interface SendMailService {

	public boolean sendMail(String fromEmail, String toEmail, String subject, String message);

}
