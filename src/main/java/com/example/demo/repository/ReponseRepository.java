package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.demo.model.demande;

import com.example.demo.model.Reponse;
@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {
   /*Page<Reponse> findByDemandeId(Long demandeId);
   Optional<Reponse> findByIdAndDemandeId(Long id, Long demandeId);*/
	List<Reponse> findByDemandeId(Long demandeId);
	   Optional<Reponse> findByIdAndDemandeId(Long id, Long demandeId);
	
}
