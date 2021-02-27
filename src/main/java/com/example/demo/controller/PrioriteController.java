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
import com.example.demo.model.Priorite;
import com.example.demo.repository.PrioriteRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PrioriteController {
	@Autowired
	private PrioriteRepository prioriteRepository;
	
	//get all employee
	@GetMapping("/priorites")
	public List<Priorite>getAllPriorites(){
		return prioriteRepository.findAll();}
	
	@GetMapping("/priorites/{id}")
    public Priorite getPrioriteByID(@PathVariable Long id) {
    	Optional<Priorite> optPriorite = prioriteRepository.findById(id);
    	
    		return optPriorite.get();
    	}
    	
	//create employee rest api
		@PostMapping("/priorites")
		public Priorite createPriorite(@RequestBody Priorite priorite) {
			return prioriteRepository.save(priorite);}
}
