package com.xmlws.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Ocena;
import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.repository.OcenaRepository;
import com.xmlws.admin.service.OcenaService;
import com.xmlws.admin.service.SmService;

@Service
public class OcenaServiceImpl implements OcenaService {

	@Autowired
	private OcenaRepository ocenaRepository;
	
	@Autowired
	private SmService smestajService;
	
	@Override
	public Ocena novaOcena(int rating, Smestaj smestaj, RegistrovaniKorisnik korisnik) {
		Ocena ocena = new Ocena();
		ocena.setRating(rating);
		ocena.setSmestaj(smestaj);
		ocena.setRegistrovaniKorisnik(korisnik);
		int sum = 0;
		int avg = 0;
		
		ocenaRepository.save(ocena);
		List<Ocena> oceneSmestaja = ocenaRepository.findBySmestaj(smestaj);
		
		for(Ocena oc : oceneSmestaja) {
			sum = sum + oc.getRating();
		}
		
		avg = sum / oceneSmestaja.size();
		smestaj.setOcena(avg);
		smestajService.save(smestaj);
		
		return ocena;
	}

}
