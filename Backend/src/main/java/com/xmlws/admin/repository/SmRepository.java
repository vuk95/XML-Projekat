package com.xmlws.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Smestaj;

@Repository
public interface SmRepository extends JpaRepository<Smestaj, Long>{
	
	Smestaj findByNaziv(String naziv);
	List<Smestaj> findByAgentEmail(String email);
	
}
