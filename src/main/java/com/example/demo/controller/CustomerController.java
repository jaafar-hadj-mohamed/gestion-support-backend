package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmailService;
import com.example.demo.model.Demande;
import com.example.demo.model.Email;
import com.example.demo.repository.DemandeRepository;
import com.example.demo.repository.EmailRepository;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {



  @Autowired
  private EmailService emailService;
  //private EmailRepository emailRepository;

 //some other code

  @PostMapping(value = "/email")
  public ResponseEntity<Email> enviarEmail( @RequestBody Email email){
    try {
      emailService.sendEmail(email);
      return new ResponseEntity<>(email,  HttpStatus.OK);
    } catch( MailException e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


  }
  /*@PostMapping("/email")
	public Email createEmail(@RequestBody Email email) {
		return emailRepository.save(email);
	}*/

}
