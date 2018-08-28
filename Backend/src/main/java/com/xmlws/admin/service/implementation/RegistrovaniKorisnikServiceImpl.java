package com.xmlws.admin.service.implementation;

import java.util.List;

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

}
