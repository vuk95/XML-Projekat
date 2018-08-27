package com.xmlws.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmlws.admin.model.Rezervacija;
import com.xmlws.admin.repository.RezervacijaRepository;
import com.xmlws.admin.service.RezervaciijaService;

@Transactional
@Service
public class RezervacijaServiceImpl implements RezervaciijaService {

	@Autowired
	private RezervacijaRepository repository;
	
	@Override
	public Rezervacija findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Rezervacija> findAll() {
		return repository.findAll();
	}

	@Override
	public Rezervacija save(Rezervacija r) {
		return repository.save(r);
	}

	@Override
	public Rezervacija delete(Long id) {
		
		Rezervacija rezervacija = repository.getOne(id);
		
		if(rezervacija == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant reservation");
		} else {
			repository.delete(rezervacija);
		}
		
		return rezervacija;
		
		
	}

	

}
