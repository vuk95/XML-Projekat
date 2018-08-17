package com.xmlws.ws.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.ws.model.Ponuda;
import com.xmlws.ws.repository.PonudaRepository;
import com.xmlws.ws.service.PonudaService;


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

	

	
	
	

		
	
}
