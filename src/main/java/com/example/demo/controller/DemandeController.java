package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	//get demande by id rest api
		@GetMapping("/demandes/{id}")
		public ResponseEntity<Demande>getDemandeByTd(@PathVariable Long id){
			Demande demande=demandeRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+id));
			return ResponseEntity.ok(demande);
		}
		
	//update demande rest api
		@PutMapping("/demandes/{id}")
		public ResponseEntity<Demande>updateDemande(@PathVariable Long id, @RequestBody Demande demandeDetails){
			Demande demande=demandeRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+id));       
		
			demande.setNom(demandeDetails.getNom());
			demande.setPrenom(demandeDetails.getPrenom());
			demande.setEmail(demandeDetails.getEmail());
			
			Demande updateDemande = demandeRepository.save(demande);
		return ResponseEntity.ok(updateDemande);
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
