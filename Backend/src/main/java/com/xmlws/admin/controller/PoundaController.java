package com.xmlws.admin.controller;

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

import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.converters.PonudaToPonudaDTO;
import com.xmlws.admin.service.PonudaService;

@RestController
public class PoundaController {

	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private PonudaToPonudaDTO toPonudaDTO;
	
	//pretraga bez sortiranja
	@CrossOrigin
	@RequestMapping(value = "/search" , method = RequestMethod.GET , consumes="application/json")
	public ResponseEntity<List<Ponuda>> search(@RequestParam(value = "od", required = false, defaultValue = "") String od, 
			@RequestParam(value = "doDatuma", required = false, defaultValue = "") String doDatuma,
			@RequestParam(value = "brojKreveta", required = false, defaultValue = "") String brojKreveta,@RequestParam(value = "lokacija", required = false, defaultValue = "") String lokacija) {
		
		List<Ponuda> ponuda = ponudaService.findPonuda(od, doDatuma, brojKreveta,lokacija);
				
		return new ResponseEntity<>(ponuda,HttpStatus.OK);
	} 
	
	//pretrage sa sortiranje
	@CrossOrigin
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
			
			return new ResponseEntity<>(toPonudaDTO.convert(ponuda),HttpStatus.OK);
		}
		
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@CrossOrigin
	@RequestMapping(value = "/ponuda/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Ponuda> getPonuda(@PathVariable Long id) {
		
		Ponuda ponuda = ponudaService.findOne(id);
		
		return new ResponseEntity<>(ponuda,HttpStatus.OK);
	} 
	
	//napredna pretraga bez sortiranja
	@CrossOrigin
	@RequestMapping(value = "/searchAdvance" , method = RequestMethod.GET , consumes="application/json")
	public ResponseEntity<List<Ponuda>> searchAdvance(@RequestParam(value = "od", required = false, defaultValue = "") String od, 
			@RequestParam(value = "doDatuma", required = false, defaultValue = "") String doDatuma,
			@RequestParam(value = "brojKreveta", required = false, defaultValue = "") String brojKreveta,@RequestParam(value = "lokacija", required = false, defaultValue = "") String lokacija,
			@RequestParam(value = "tip", required = false, defaultValue = "") String tip,@RequestParam(value = "kategorija", required = false, defaultValue = "") String kategorija) {
		
		List<Ponuda> ponuda = ponudaService.findPonudaAdvance(od, doDatuma, brojKreveta, lokacija, tip, kategorija);
				
		return new ResponseEntity<>(ponuda,HttpStatus.OK);
	} 
	
	//napredna pretraga sa sortiranjem
	@CrossOrigin
	@RequestMapping(value = "/searchAdvance/{sort}" , method = RequestMethod.GET , consumes="application/json")
		public ResponseEntity<?> findAdvance(@PathVariable("sort") int sort,@RequestParam(value = "od", required = false, defaultValue = "") String od, 
				@RequestParam(value = "doDatuma", required = false, defaultValue = "") String doDatuma,
				@RequestParam(value = "brojKreveta", required = false, defaultValue = "") String brojKreveta,@RequestParam(value = "lokacija", required = false, defaultValue = "") String lokacija,
				@RequestParam(value = "tip", required = false, defaultValue = "") String tip,@RequestParam(value = "kategorija", required = false, defaultValue = "") String kategorija) {
		
			try {
				
				List<Ponuda> ponuda = new ArrayList<Ponuda>();
				
					if(sort == 1) {
					 ponuda = ponudaService.findPonudaAdvanceOrderByCena(od, doDatuma, brojKreveta, lokacija, tip, kategorija);
					}
					if(sort == 2) {
					 ponuda = ponudaService.findPonudaAdvanceOrderByRaiting(od, doDatuma, brojKreveta, lokacija, tip, kategorija);
					}
					if(sort == 3) {
					 ponuda = ponudaService.findPonudaAdvanceOrderByCategory(od, doDatuma, brojKreveta, lokacija, tip, kategorija);
					}
				
				return new ResponseEntity<>(toPonudaDTO.convert(ponuda),HttpStatus.OK);
			}
			
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
					
		}
	
}
