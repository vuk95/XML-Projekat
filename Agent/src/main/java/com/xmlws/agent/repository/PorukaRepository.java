package com.xmlws.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long>{

	List<Poruka> findByAgent(Korisnik agent);
	
}
