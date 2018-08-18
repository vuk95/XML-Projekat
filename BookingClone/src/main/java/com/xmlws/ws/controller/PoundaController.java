package com.xmlws.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
