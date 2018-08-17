package com.xmlws.ws.service;

import java.util.List;

import com.xmlws.ws.model.Ponuda;

public interface PonudaService {
	
	public Ponuda findOne(Long id);
	public List<Ponuda> findAll();
	public Ponuda save(Ponuda p);
	//public List<Ponuda> findOffer(String od,String _do,String brojKreveta);
	
}
