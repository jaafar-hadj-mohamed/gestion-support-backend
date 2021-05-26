package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Faq;
import com.example.demo.model.Macro;
import com.example.demo.repository.FaqRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class FaqController {

	@Autowired
	private FaqRepository faqRepository;
	
	
	
	@GetMapping("/faqs")
	public List<Faq>getAllFaqs(){
		return faqRepository.findAll();
	}
	//get faq by id rest api
	@GetMapping("/faqs/{id}")
	public ResponseEntity<Faq>getFaqByTd(@PathVariable Long id){
		Faq faq=faqRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Faq not exist with id:"+id));
		return ResponseEntity.ok(faq);
	}
	
	@PostMapping("/faqs")
	public Faq createFaq(@RequestBody Faq faq) {
		return faqRepository.save(faq);
	}
	
	
	//update faq rest api
			@PutMapping("/faqs/{id}")
			public ResponseEntity<Faq>updateFaq(@PathVariable Long id, @RequestBody Faq faqDetails){
				Faq faq=faqRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+id));       
			
				faq.setQuestion(faqDetails.getQuestion());
				faq.setReponse(faqDetails.getReponse());
				
				
				Faq updateFaq = faqRepository.save(faq);
			return ResponseEntity.ok(updateFaq);
			}
	
	
			@DeleteMapping("/faqs/{id}")
			public ResponseEntity<Map<String,Boolean>>deleteFaq(@PathVariable Long id){
				Faq faq=faqRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("dddd:"+id));
				faqRepository.delete(faq);
				Map<String,Boolean>response=new HashMap<>();
				response.put("delete", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
}













	
	
	
	