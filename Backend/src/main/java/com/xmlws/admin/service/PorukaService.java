package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.Poruka;

public interface PorukaService {

	public Poruka findOne(Long id);
	
	public List<Poruka> findAll();
	
	public Poruka save(Poruka p);
	
}
