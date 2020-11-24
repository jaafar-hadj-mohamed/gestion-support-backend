package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Demande;



@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long>{
	//List<Demande> findByProblemId(Long problemId);

}
