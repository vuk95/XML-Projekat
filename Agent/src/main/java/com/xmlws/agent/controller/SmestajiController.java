package com.xmlws.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmlws.agent.back.AddSmestajRequest;
import com.xmlws.agent.back.AddSmestajResponse;
import com.xmlws.agent.back.BackendServicePort;
import com.xmlws.agent.back.BackendServicePortService;
import com.xmlws.agent.model.Ponuda;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.service.PonudaService;
import com.xmlws.agent.service.SmestajService;

@Controller
@RequestMapping("/smestaji")
public class SmestajiController {
	
	@Autowired
	private SmestajService sm_service;
	
	@Autowired
	private PonudaService p_service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
		
	}
	
	@RequestMapping(value = "/getSviSmestaji", method = RequestMethod.GET)
	public String rekviziti(ModelMap map) {
		
		map.put("smestaji", sm_service.findAll());
		return "sviSmestaji";
		
	}
	
	
	@RequestMapping(value = "/getSviSmestaji/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
			
		map.put("smestaj", new Smestaj());
		
		return "addSmestaj";
		
	}
	
	@RequestMapping(value = "getSviSmestaji/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("smestaj") Smestaj smestaj, ModelMap map) {
	
		sm_service.save(smestaj);
		
		com.xmlws.agent.back.Smestaj demoSmestaj = new com.xmlws.agent.back.Smestaj();
		demoSmestaj.setNaziv(smestaj.getNaziv());
		demoSmestaj.setAgent(null);
		demoSmestaj.setId(smestaj.getId());
		demoSmestaj.setKategorija(smestaj.getKategorija());
		demoSmestaj.setLokacija(smestaj.getLokacija());
		demoSmestaj.setOcena(smestaj.getOcena());
		demoSmestaj.setOpis(smestaj.getOpis());
		demoSmestaj.setTip(smestaj.getTip());
		demoSmestaj.setWifi(smestaj.isWifi());
		demoSmestaj.setTV(smestaj.isTv());
		demoSmestaj.setPolupansion(smestaj.isPolupansion());
		demoSmestaj.setPansion(smestaj.isPansion());
		demoSmestaj.setParking(smestaj.isParking());
		demoSmestaj.setKupatilo(smestaj.isKupatilo());
		demoSmestaj.setKuhinja(smestaj.isKuhinja());
		demoSmestaj.setDorucak(smestaj.isDorucak());
			
		BackendServicePortService backServicePortService = new BackendServicePortService();
		BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
		AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
		addSmestajRequest.setSmestaj(demoSmestaj);
		AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
		
		System.out.println("U glavnu bazu upisan smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
		
		return "redirect:../getSviSmestaji";
	
	}
	
	@RequestMapping(value = "getSviSmestaji/show/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable Long id, ModelMap map){

    	map.put("smestaj",sm_service.findOne(id));
    	map.put("slike", sm_service.findOne(id).getMojeSlike());
    	map.put("ponude", sm_service.findOne(id).getMojePonude());
    	return "showSmestaj";
		
    }
	
	@RequestMapping(value = "/getSvePonude/add/{id}", method = RequestMethod.GET)
	public String addPonude(@PathVariable Long id, ModelMap map) {
		
		
		map.put("ponuda", new Ponuda());
		map.put("smestaj", sm_service.findOne(id));
		
		
		return "addPonuda";
		
	}
	
	@RequestMapping(value = "/getSvePonude/add", method = RequestMethod.POST)
	public String addPonude(@ModelAttribute("ponuda") Ponuda ponuda, ModelMap map) {
		
		p_service.save(ponuda);
		Smestaj s = sm_service.findOne(ponuda.getSmestaj().getId());
		s.getMojePonude().add(ponuda);
		sm_service.save(s);
		
		return "redirect:/smestaji/getSviSmestaji";
	
	}

}
