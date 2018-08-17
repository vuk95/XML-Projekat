package com.xmlws.ws.service;

import java.util.Date;
import java.util.List;

import com.xmlws.ws.model.Ponuda;

public interface PonudaService {
	
	public Ponuda findOne(Long id);
	public List<Ponuda> findAll();
	public Ponuda save(Ponuda p);
	public List<Ponuda> searchOrderByCena(Date od,Date _do,String naziv,int brojKreveta);
	public List<Ponuda> searchOrderByRaiting(Date od,Date _do,String naziv,int brojKreveta);
	public List<Ponuda> searchOrderByCategory(Date od,Date _do,String naziv,int brojKreveta);

}