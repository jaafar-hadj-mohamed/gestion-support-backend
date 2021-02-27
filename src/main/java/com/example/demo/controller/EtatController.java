package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Etat;
import com.example.demo.model.Problem;
import com.example.demo.repository.EtatRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EtatController {
	@Autowired
	private EtatRepository etatRepository;
	
	
	//get all employee
			@GetMapping("/etats")
			public List<Etat>getAllEtats(){
				return etatRepository.findAll();}
			
			@GetMapping("/etats/{id}")
		    public Etat getEtatByID(@PathVariable Long id) {
		    	Optional<Etat> optEtat = etatRepository.findById(id);
		    	
		    		return optEtat.get();
		    	}
		    	
			//create employee rest api
				@PostMapping("/etats")
				public Etat createEtat(@RequestBody Etat etat) {
					return etatRepository.save(etat);}
				

}
