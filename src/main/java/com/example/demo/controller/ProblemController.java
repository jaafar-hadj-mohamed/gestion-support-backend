package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
	//create employee rest api
		@PostMapping("/problemes")
		public Problem createProblem(@RequestBody Problem problem) {
			return problemRepository.save(problem);
		}
}
