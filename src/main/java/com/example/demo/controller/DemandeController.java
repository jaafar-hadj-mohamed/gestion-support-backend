package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;

import com.example.demo.repository.DemandeRepository;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeController {
	@Autowired
	private DemandeRepository demandeRepository;
	
	//get all employee
		@GetMapping("/demandes")
		public List<Demande>getAllDemandes(){
			return demandeRepository.findAll();}
	//create employee rest api
		@PostMapping("/demandes")
		public Demande createDemande(@RequestBody Demande demande) {
			return demandeRepository.save(demande);
		}

}
