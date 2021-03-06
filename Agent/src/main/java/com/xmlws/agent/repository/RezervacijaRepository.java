package com.xmlws.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long>{
	
	List<Rezervacija> findByPonudaId(Long id);
	
}
