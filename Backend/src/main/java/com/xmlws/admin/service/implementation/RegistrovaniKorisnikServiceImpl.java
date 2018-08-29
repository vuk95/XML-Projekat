package com.xmlws.admin.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.repository.RegistrovaniKorisnikRepository;
import com.xmlws.admin.service.RegistrovaniKorisnikService;

@Service
public class RegistrovaniKorisnikServiceImpl implements RegistrovaniKorisnikService {

	@Autowired
	private RegistrovaniKorisnikRepository registrovaniKorisnikRepo;
	
	@Override
	public List<RegistrovaniKorisnik> findAll() {
		return registrovaniKorisnikRepo.findAll();
	}

	@Override
	public RegistrovaniKorisnik findById(Long id) {
		Optional<RegistrovaniKorisnik> korisnik = registrovaniKorisnikRepo.findById(id);
		if(korisnik.isPresent()) {
			return korisnik.get();
		} else {
			return null;
		}
	}

	@Override
	public RegistrovaniKorisnik save(RegistrovaniKorisnik korisnik) {
		return registrovaniKorisnikRepo.save(korisnik);
	}

	@Override
	public RegistrovaniKorisnik delete(RegistrovaniKorisnik korisnik) {
		registrovaniKorisnikRepo.delete(korisnik);
		
		return korisnik;
	}

}
