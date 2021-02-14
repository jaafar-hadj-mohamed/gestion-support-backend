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

import com.example.demo.model.Demande;
import com.example.demo.model.Problem;

import com.example.demo.repository.ProblemRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProblemController {

	@Autowired
	private ProblemRepository problemRepository;
	
	//get all employee
		@GetMapping("/problemes")
		public List<Problem>getAllProblemes(){
			return problemRepository.findAll();}
		
	@GetMapping("/problemes/{id}")
    public Problem getProblemByID(@PathVariable Long id) {
    	Optional<Problem> optProblem = problemRepository.findById(id);
    	
    		return optProblem.get();
    	}
    	
	//create employee rest api
		@PostMapping("/problemes")
		public Problem createProblem(@RequestBody Problem problem) {
			return problemRepository.save(problem);
		}
}
