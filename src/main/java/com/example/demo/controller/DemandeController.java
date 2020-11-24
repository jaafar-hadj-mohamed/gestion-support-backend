package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Demande;
//import com.example.demo.model.Student;
import com.example.demo.repository.DemandeRepository;
import com.example.demo.repository.ProblemRepository;




@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeController {
	@Autowired
	private DemandeRepository demandeRepository;
	
	/*@Autowired
	private ProblemRepository problemRepository;*/
	
	//get all employee
		@GetMapping("/demandes")
		public List<Demande>getAllDemandes(){
			return demandeRepository.findAll();}
	//create employee rest api
		@PostMapping("/demandes")
		public Demande createDemande(@RequestBody Demande demande) {
			return demandeRepository.save(demande);
		}
		
		
		/*@PostMapping("/problems/{problemId}/demandes")
	    public Demande addDemande(@PathVariable Long problemId,
	                            @Valid @RequestBody Demande demande) {
	        return problemRepository.findById(problemId)
	                .map(problem -> {
	                	demande.setProblem(problem);
	                    return demandeRepository.save(demande);
	                }).orElseThrow(() -> new ResourceNotFoundException("Problem not found!"));
	    }*/
		
		/*@GetMapping("/problemes/{problemId}/demandes")
	    public List<Demande> getContactByProblemId(@PathVariable Long problemId) {
	    	
	        
	    	
	    	return demandeRepository.findByProblemId(problemId);
	    }*/

}
