package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.Sifrarnik;
import com.xmlws.admin.dto.SifrarnikDTO;

public interface SifrarnikService {

	public List<Sifrarnik> findAll();
	
	public Sifrarnik findOne(Long id);
	
	public Sifrarnik save(Sifrarnik sifrarnik);
	
	public Sifrarnik novaSifra(SifrarnikDTO dto);
}
