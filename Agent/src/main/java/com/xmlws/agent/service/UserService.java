package com.xmlws.agent.service;

import java.util.List;

import com.xmlws.agent.model.Korisnik;

public interface UserService {
	
	public List<Korisnik> findAll();
	
	public Korisnik findById(Long id);

}
