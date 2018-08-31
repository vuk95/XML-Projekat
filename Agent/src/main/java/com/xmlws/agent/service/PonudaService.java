package com.xmlws.agent.service;

import java.util.List;

import com.xmlws.agent.model.Ponuda;

public interface PonudaService {
	
	public Ponuda save(Ponuda p);
	public Ponuda findOne(Long id);
	public List<Ponuda> findALl();

}
