package com.Sample.Mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String Subject, String body, File attachment) throws MessagingException {
try {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
    mimeMessageHelper.setFrom("vinoth.berry.18@gmail.com");//rahulrajaspringboot@gmail.com
    mimeMessageHelper.setTo(toEmail);
    mimeMessageHelper.setText(body);
    mimeMessageHelper.setSubject(Subject);

    FileSystemResource fileSystemResource =
            new FileSystemResource(attachment);
    mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
    mailSender.send(mimeMessage);
}catch(Exception e){
    System.out.println(e.getMessage());
}
        System.out.println("Message Sent Successfully .....");
    }
}
