package com.example.demo.dao;


import javax.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.demo.model.Email;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service

public class EmailService {
	
    private JavaMailSender javaMailSender;
    

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
        
        
        
    }
    
    
    
	public void sendEmail(Email email) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email.getEmail());
        mail.setFrom("noreply@baeldung.com");
        mail.setSubject("Contacto: "+email.getNombre());
        mail.setText("Bonjour"+email.getId()+"l'equipe proged a bien recu votre demande nous vous repondrons dans mois de 48h. Votre demande est:  -"+email.getMensaje());
         
        javaMailSender.send(mail);
    }

}
