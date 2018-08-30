package com.xmlws.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmlws.agent.back.AddPonudaRequest;
import com.xmlws.agent.back.AddPonudaResponse;
import com.xmlws.agent.back.AddSmestajRequest;
import com.xmlws.agent.back.AddSmestajResponse;
import com.xmlws.agent.back.BackendServicePort;
import com.xmlws.agent.back.BackendServicePortService;
import com.xmlws.agent.back.GetSmestajRequest;
import com.xmlws.agent.back.GetSmestajResponse;
import com.xmlws.agent.model.Ponuda;
import com.xmlws.agent.model.Rezervacija;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.service.PonudaService;
import com.xmlws.agent.service.RezervacijaService;
import com.xmlws.agent.service.SmestajService;

@Controller
@RequestMapping("/smestaji")
public class SmestajiController {
	
	@Autowired
	private SmestajService sm_service;
	
	@Autowired
	private PonudaService p_service;
	
	@Autowired
	private RezervacijaService rez_service;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
		
	}
	
	@RequestMapping(value = "/getSviSmestaji", method = RequestMethod.GET)
	public String sviSmestaji(ModelMap map) {
		
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
		
		com.xmlws.agent.back.Ponuda demoPonuda = new com.xmlws.agent.back.Ponuda();
		demoPonuda.setId(ponuda.getId());
		demoPonuda.setBrojKreveta(ponuda.getBrojKreveta());
		demoPonuda.setOd(ponuda.getOd());
		demoPonuda.setDoDatuma(ponuda.getDoDatuma());
		demoPonuda.setCena(ponuda.getCena());
		
		BackendServicePortService backServicePortService = new BackendServicePortService();
		BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
		
		GetSmestajRequest getSmestajRequest = new GetSmestajRequest();
		getSmestajRequest.setNaziv(ponuda.getSmestaj().getNaziv());
		GetSmestajResponse getSmestajResponse = port.getSmestaj(getSmestajRequest);
		
		com.xmlws.agent.back.Smestaj getted = getSmestajResponse.getSmestaj();
		
		demoPonuda.setSmestaj(getSmestajResponse.getSmestaj());
		
		AddPonudaRequest addPonudaRequest = new AddPonudaRequest();
		addPonudaRequest.setPonuda(demoPonuda);
		AddPonudaResponse addPonudaResponse = port.addPonuda(addPonudaRequest);
		
		System.out.println("U glavnu bazu upisana ponuda: " + addPonudaResponse.getPonuda().getCena());
		
		
		Smestaj s = sm_service.findOne(ponuda.getSmestaj().getId());
		s.getMojePonude().add(ponuda);
		sm_service.save(s);
		
		//Nesto jebe da ga doda u listu
		//getted.getPonuda().add(demoPonuda);
		
		//AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
		//addSmestajRequest.setSmestaj(getted);
		//AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
		
		//System.out.println("U glavnoj bazi azuriran smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
		
		
		return "redirect:/smestaji/getSviSmestaji";
	
	}
	
	@RequestMapping(value = "getSveRez/{id}", method = RequestMethod.GET)
    public String showRez(@PathVariable Long id, ModelMap map){
		
		Ponuda p = p_service.findOne(id);
		map.put("rezervacije", p.getRezervacije());
		
    	return "rezZaPonudu";
		
    }
	
	@RequestMapping(value = "potvrdiRez/{id}", method = RequestMethod.GET)
    public String acceptRes(@PathVariable Long id, ModelMap map){
		
		Rezervacija r = rez_service.findOne(id);
		
		r.setPotvrdjeno(true);
		rez_service.save(r);
		//map.put("rezervacije", p.getRezervacije());
		
    	return "redirect:/smestaji/getSveRez/" + r.getPonuda().getId();
		
    }
	
}
