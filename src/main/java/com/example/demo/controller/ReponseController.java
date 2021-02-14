package com.example.demo.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demande;
import com.example.demo.model.Reponse;
import com.example.demo.repository.DemandeRepository;
import com.example.demo.repository.ReponseRepository;
import com.example.demo.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReponseController {

	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	
	
	@GetMapping("/reponses")
	public List<Reponse>getAllReponses(){
		return reponseRepository.findAll();}
	
	/*@GetMapping("/demandes/{demandeId}/reponses")
    public Page<Reponse> getAllReponseByDemandeId(@PathVariable (value = "demandeId") Long demandeId,
                                                Pageable pageable) {
        return reponseRepository.findByDemandeId(demandeId, pageable);
    }*/
	
	
	@GetMapping("/demandes/{demandeId}/reponses")
    public List<Reponse> getAllReponseByDemandeId(@PathVariable (value = "demandeId") Long demandeId,
                                                Pageable pageable) {
        return reponseRepository.findByDemandeId(demandeId);
    }

	/*@GetMapping("/demandes/{demandeId}/reponses")
	public ResponseEntity<Reponse>getReponsesByTd(@PathVariable (value = "demandeId") Long demandeId){
		Reponse reponse=reponseRepository.findById(demandeId)
				
				.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+demandeId));
		return ResponseEntity.ok(reponse);
	}*/
	@GetMapping("/reponses/{id}")
	public ResponseEntity<Reponse>getReponseByTd(@PathVariable Long id){
		Reponse reponse=reponseRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+id));
		return ResponseEntity.ok(reponse);
	}
	
	
	@PostMapping("/demandes/{demandeId}/reponses")
    public Reponse addReponse(@PathVariable Long demandeId,
                             @RequestBody Reponse reponse) {
        return demandeRepository.findById(demandeId)
                .map(demande -> {
                    reponse.setDemande(demande);
                    return reponseRepository.save(reponse);
                }).orElseThrow(() -> new ResourceNotFoundException("Problem not found!"));
    }
    
	
	
}
