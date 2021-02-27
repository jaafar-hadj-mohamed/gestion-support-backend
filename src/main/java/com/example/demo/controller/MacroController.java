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
import com.example.demo.model.Demande;
import com.example.demo.model.Faq;
import com.example.demo.model.Macro;
import com.example.demo.repository.MacroRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class MacroController {
	@Autowired
	private MacroRepository macroRepository;
	
	
	@GetMapping("/macros")
	public List<Macro>getAllmacros(){
		return macroRepository.findAll();
	}
	
	@PostMapping("/macros")
	public Macro createFaq(@RequestBody Macro macro) {
		return macroRepository.save(macro);
	}
	
	//get macro by id rest api
			@GetMapping("/macros/{id}")
			public ResponseEntity<Macro>getMacroByTd(@PathVariable Long id){
				Macro macro=macroRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Macro not exist with id:"+id));
				return ResponseEntity.ok(macro);
			}
	
	//update faq rest api
			@PutMapping("/macros/{id}")
			public ResponseEntity<Macro>updateMacro(@PathVariable Long id, @RequestBody Macro macroDetails){
				Macro macro=macroRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Demande not exist with id:"+id));       
			
				macro.setTitre(macroDetails.getTitre());
				macro.setReponse(macroDetails.getReponse());
				
				
				Macro updateMacro = macroRepository.save(macro);
			return ResponseEntity.ok(updateMacro);
			}
	
	
			@DeleteMapping("/macros/{id}")
			public ResponseEntity<Map<String,Boolean>>deleteMacro(@PathVariable Long id){
				Macro macro=macroRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("dddd:"+id));
				macroRepository.delete(macro);
				Map<String,Boolean>response=new HashMap<>();
				response.put("delete", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}
