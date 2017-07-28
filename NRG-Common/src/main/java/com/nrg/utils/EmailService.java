package com.nrg.utils;

import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.nrg.models.Email;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine htmlTemplateEngine;

	
	/* Common Mail Sender.*/
	 
	public void sendMail(final Email email, final Locale locale) throws Exception {

		// Prepare the evaluation context
		final Context ctx = new Context(locale);
		ctx.setVariables(email.getContextMap());

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setSubject(email.getSubject());
		message.setFrom(email.getFrom());
		message.setTo(email.getTo());

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.htmlTemplateEngine.process(email.getTemplateUri(), ctx);
		message.setText(htmlContent, true);

		// Add the inline image, referenced from the HTML code as
		// "cid:${imageResourceName}"
		for (MultipartFile multipartFile : email.getInlineImages()) {
			final InputStreamSource imageSource = new ByteArrayResource(multipartFile.getBytes());
			message.addInline(multipartFile.getName(), imageSource, multipartFile.getContentType());
		}

		// Add the attachment
		for (MultipartFile multipartFile : email.getAttatchments()) {
			final InputStreamSource attachmentSource = new ByteArrayResource(multipartFile.getBytes());
			message.addAttachment(multipartFile.getOriginalFilename(), attachmentSource,
					multipartFile.getContentType());
		}

		// Send mail
		this.mailSender.send(mimeMessage);
	}

}