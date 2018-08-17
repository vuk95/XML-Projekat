package com.xmlws.ws.controller;

import java.util.Date;
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
	public ResponseEntity<List<Ponuda>> search(@RequestParam(value = "od", required = false, defaultValue = "") Date od, 
			@RequestParam(value = "_do", required = false, defaultValue = "") Date _do, @RequestParam(value = "naziv", required = false, defaultValue = "") String naziv,
			@RequestParam(value = "brojKreveta", required = false, defaultValue = "") int brojKreveta) {
		
		List<Ponuda> ponuda = ponudaService.searchOrderByCena(od, _do, naziv, brojKreveta); 
				
		return new ResponseEntity<>(ponuda,HttpStatus.OK);
	} 
	
}
