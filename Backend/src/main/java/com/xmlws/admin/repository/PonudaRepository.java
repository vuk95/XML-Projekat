package com.xmlws.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Ponuda;

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

		//napredna pretraga
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContaining(String od,String _do,String brojKreveta,String lokacija,String tip,String kategorija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderByCena(String od,String _do,String brojKreveta,String lokacija,String tip,String kategorija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderBySmestajKategorija(String od,String _do,String brojKreveta,String lokacija,String tip,String kategorija);
		
		List<Ponuda> findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderBySmestajOcena(String od,String _do,String brojKreveta,String lokacija,String tip,String kategorija);

}
