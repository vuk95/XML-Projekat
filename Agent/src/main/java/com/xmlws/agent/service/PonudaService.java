package com.xmlws.agent.service;

import com.xmlws.agent.model.Ponuda;

public interface PonudaService {
	
	public Ponuda save(Ponuda p);
	public Ponuda findOne(Long id);

}
