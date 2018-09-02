package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.Smestaj;

public interface SmService {
	
	Smestaj save(Smestaj s);
	Smestaj findOne(String naziv);
	List<Smestaj> getSmestajByAgent(String email);
	List<Smestaj> findAll();
}
