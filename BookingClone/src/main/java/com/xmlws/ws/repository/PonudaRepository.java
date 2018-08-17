package com.xmlws.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xmlws.ws.model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda,Long> {

	
		//obicna pretraga
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderByCena
		(String naziv, int brojKreveta);
		
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderBySmestajKategorija
		(String naziv, int brojKreveta);
		
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKreveta
		(String naziv, int brojKreveta);
		
	
	
}
