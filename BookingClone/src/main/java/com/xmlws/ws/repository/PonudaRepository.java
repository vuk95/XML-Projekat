package com.xmlws.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.ws.model.Ponuda;

@Repository
public interface PonudaRepository extends JpaRepository<Ponuda,Long> {

	
		//obicna pretraga
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderByCena
		(String naziv, int brojKreveta);
		
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderBySmestajKategorija
		(String naziv, int brojKreveta);
		
		List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojKreveta
		(String naziv, int brojKreveta);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContaining(String od,String _do,String brojKreveta,String lokacija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderByCena(String od,String _do,String brojKreveta,String lokacija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderBySmestajKategorija(String od,String doDatuma,String brojKreveta,String lokacija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderBySmestajOcena(String od,String doDatuma,String brojKreveta,String lokacija);
}
