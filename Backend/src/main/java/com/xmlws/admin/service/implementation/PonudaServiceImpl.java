package com.xmlws.admin.service.implementation;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.repository.PonudaRepository;
import com.xmlws.admin.service.PonudaService;

@Transactional
@Service
public class PonudaServiceImpl implements PonudaService {

	@Autowired
	private PonudaRepository repository;
	
	@Override
	public Ponuda findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Ponuda> findAll() {
		return repository.findAll();
	}

	@Override
	public Ponuda save(Ponuda p) {
		return repository.save(p);
	}

	//Deo koji se tice obicne pretrage
	@Override
	public List<Ponuda> searchOrderByCena(Date od, Date _do, String naziv, int brojKreveta) {
		return repository.findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderByCena(naziv, brojKreveta);
	}

	@Override
	public List<Ponuda> searchOrderByRaiting(Date od, Date _do, String naziv, int brojKreveta) {
		return repository.findBySmestajLokacijaContainingIgnoreCaseAndBrojKreveta(naziv, brojKreveta);
	}

	@Override
	public List<Ponuda> searchOrderByCategory(Date od, Date _do, String naziv, int brojKreveta) {
		return repository.findBySmestajLokacijaContainingIgnoreCaseAndBrojKrevetaOrderBySmestajKategorija(naziv, brojKreveta);
	}
	
	
	//Privremeno dok ne nadjem bolje resenje
	@Override
	public List<Ponuda> findPonuda(String od, String doDatuma, String brojKreveta,String lokacija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContaining(od, doDatuma, brojKreveta,lokacija);
	}

	@Override
	public List<Ponuda> findPonudaOrderByCenaAsc(String od, String doDatuma, String brojKreveta, String lokacija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderByCena(od, doDatuma, brojKreveta, lokacija);
	}

	@Override
	public List<Ponuda> findOrderByCategory(String od, String doDatuma, String brojKreveta, String lokacija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderBySmestajKategorija(od, doDatuma, brojKreveta, lokacija);
	}

	@Override
	public List<Ponuda> findOrderByRaiting(String od, String doDatuma, String brojKreveta, String lokacija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingOrderBySmestajOcena(od, doDatuma, brojKreveta, lokacija);
	}

	
	//Deo koji se tice napredne pretrage
	@Override
	public List<Ponuda> findPonudaAdvance(String od, String _do, String brojKreveta, String lokacija, String tip,
			String kategorija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContaining(od, _do, brojKreveta, lokacija, tip, kategorija);
	}

	@Override
	public List<Ponuda> findPonudaAdvanceOrderByCena(String od, String _do, String brojKreveta, String lokacija,
			String tip, String kategorija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderByCena(od, _do, brojKreveta, lokacija, tip, kategorija);
	}

	@Override
	public List<Ponuda> findPonudaAdvanceOrderByCategory(String od, String _do, String brojKreveta, String lokacija,
			String tip, String kategorija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderBySmestajKategorija(od, _do, brojKreveta, lokacija, tip, kategorija);
	}

	@Override
	public List<Ponuda> findPonudaAdvanceOrderByRaiting(String od, String _do, String brojKreveta, String lokacija,
			String tip, String kategorija) {
		return repository.findByOdIgnoreCaseContainingAndDoDatumaIgnoreCaseContainingAndBrojKrevetaIgnoreCaseContainingAndSmestajLokacijaIgnoreCaseContainingAndSmestajTipIgnoreCaseContainingAndSmestajKategorijaIgnoreCaseContainingOrderBySmestajOcena(od, _do, brojKreveta, lokacija, tip, kategorija);
	}

	

	
	
	

		
	
}
