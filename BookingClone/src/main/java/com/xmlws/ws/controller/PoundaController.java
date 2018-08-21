package com.xmlws.ws.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.ws.model.Ponuda;
import com.xmlws.ws.service.PonudaService;

@RestController
public class PoundaController {

	@Autowired
	private PonudaService ponudaService;
	
	@RequestMapping(value = "/search" , method = RequestMethod.GET , consumes="application/json")
	public ResponseEntity<List<Ponuda>> search(@RequestParam(value = "od", required = false, defaultValue = "") String od, 
			@RequestParam(value = "doDatuma", required = false, defaultValue = "") String doDatuma,
			@RequestParam(value = "brojKreveta", required = false, defaultValue = "") String brojKreveta,@RequestParam(value = "lokacija", required = false, defaultValue = "") String lokacija) {
		
		List<Ponuda> ponuda = ponudaService.findPonuda(od, doDatuma, brojKreveta,lokacija);
				
		return new ResponseEntity<>(ponuda,HttpStatus.OK);
	} 
	
	//pretrage sa sortiranje
	@RequestMapping(value = "/search/{sort}" , method = RequestMethod.GET , consumes="application/json")
	public ResponseEntity<?> find(@PathVariable("sort") int sort,@RequestParam(value = "od", required = false, defaultValue = "") String od, 
			@RequestParam(value = "doDatuma", required = false, defaultValue = "") String doDatuma,
			@RequestParam(value = "brojKreveta", required = false, defaultValue = "") String brojKreveta,@RequestParam(value = "lokacija", required = false, defaultValue = "") String lokacija) {
	
		try {
			
			List<Ponuda> ponuda = new ArrayList<Ponuda>();
			
				if(sort == 1) {
				 ponuda = ponudaService.findPonudaOrderByCenaAsc(od, doDatuma, brojKreveta, lokacija);
				}
				if(sort == 2) {
				 ponuda = ponudaService.findOrderByRaiting(od, doDatuma, brojKreveta, lokacija);
				}
				if(sort == 3) {
				 ponuda = ponudaService.findOrderByCategory(od, doDatuma, brojKreveta, lokacija);
				}
			
			return new ResponseEntity<>(ponuda,HttpStatus.OK);
		}
		
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
				
	}
	
}
