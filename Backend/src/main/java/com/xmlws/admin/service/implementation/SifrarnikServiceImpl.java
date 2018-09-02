package com.xmlws.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Sifrarnik;
import com.xmlws.admin.dto.SifrarnikDTO;
import com.xmlws.admin.repository.SifrarnikRepository;
import com.xmlws.admin.service.SifrarnikService;

@Service
public class SifrarnikServiceImpl implements SifrarnikService {

	@Autowired
	private SifrarnikRepository sifrarnikRepo;
	
	@Override
	public List<Sifrarnik> findAll() {
		return sifrarnikRepo.findAll();
	}

	@Override
	public Sifrarnik findOne(Long id) {
		return sifrarnikRepo.getOne(id);
	}

	@Override
	public Sifrarnik save(Sifrarnik sifrarnik) {
		return sifrarnikRepo.save(sifrarnik);
	}

	@Override
	public Sifrarnik novaSifra(SifrarnikDTO dto) {
		Sifrarnik sifra = new Sifrarnik();
		sifra.setSifra(dto.getSifra());
		sifra.setVrednost(dto.getVrednost());
		
		sifrarnikRepo.save(sifra);
		
		return sifra;
	}

}
