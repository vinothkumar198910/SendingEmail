package com.Sample.Mail;

import com.Sample.Mail.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import javax.mail.MessagingException;
import java.io.File;

@SpringBootApplication
public class MailApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException
	{
		var file = "E:/Untitled.png";
		senderService.sendEmail("vinoth.berry.18@gmail.com","Welcome User","Welcome", new File(file));//rahulraja2699@gmail.com
		}

}
