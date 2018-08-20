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
	
	//privremeno
	public List<Ponuda> findPonuda(String od,String _do,String brojKreveta,String lokacija);
	public List<Ponuda> findPonudaOrderByCenaAsc(String od,String _do,String brojKreveta,String lokacija);
	public List<Ponuda> findOrderByCategory(String od,String doDatuma,String brojKreveta,String lokacija);
	public List<Ponuda> findOrderByRaiting(String od,String doDatuma,String brojKreveta,String lokacija);
	

}
