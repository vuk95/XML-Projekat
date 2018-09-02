package com.xmlws.agent.controller;

import java.util.ArrayList;

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
import com.xmlws.agent.back.UpdateRezervacijaRequest;
import com.xmlws.agent.back.UpdateRezervacijaResponse;
import com.xmlws.agent.model.Ponuda;
import com.xmlws.agent.model.Poruka;
import com.xmlws.agent.model.Rezervacija;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.repository.UserRepository;
import com.xmlws.agent.service.PonudaService;
import com.xmlws.agent.service.PorukaService;
import com.xmlws.agent.service.RezervacijaService;
import com.xmlws.agent.service.SmestajService;
import com.xmlws.agent.service.SynchronizeService;
import com.xmlws.agent.service.UserService;

@Controller
@RequestMapping("/smestaji")
public class SmestajiController {
	
	@Autowired
	private SmestajService sm_service;
	
	@Autowired
	private PonudaService p_service;
	
	@Autowired
	private RezervacijaService rez_service;
	
	@Autowired
	private SynchronizeService synchroservice;
	
	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private UserService korisnickiService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
		
	}
	
	@RequestMapping(value = "/sync", method = RequestMethod.GET)
	public String sync(ModelMap map) {
		
		//SAMO PROBNO PRAVI TEK KAD BUDE LOGIN
		//synchroservice.getAllSmestajByAgent("ana@gmail.com");
		synchroservice.getAllSmestaj();
		synchroservice.getAllPonuda();
		synchroservice.getAllRezervacija();
		
		map.put("smestaji", sm_service.findAll());
		return "sviSmestaji";
		
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
	
	@RequestMapping(value = "getSviSmestaji/zauzmi/{id}", method = RequestMethod.GET)
    public String zauzmi(@PathVariable Long id, ModelMap map){
		
		
		Smestaj s = sm_service.findOne(id);
		s.setZauzet(true);
		sm_service.save(s);
		
		com.xmlws.agent.back.Smestaj demoSmestaj = new com.xmlws.agent.back.Smestaj();
		demoSmestaj.setNaziv(s.getNaziv());
		demoSmestaj.setAgent(null);
		demoSmestaj.setId(s.getId());
		demoSmestaj.setKategorija(s.getKategorija());
		demoSmestaj.setLokacija(s.getLokacija());
		demoSmestaj.setOcena(s.getOcena());
		demoSmestaj.setOpis(s.getOpis());
		demoSmestaj.setTip(s.getTip());
		demoSmestaj.setWifi(s.isWifi());
		demoSmestaj.setTV(s.isTv());
		demoSmestaj.setPolupansion(s.isPolupansion());
		demoSmestaj.setPansion(s.isPansion());
		demoSmestaj.setParking(s.isParking());
		demoSmestaj.setKupatilo(s.isKupatilo());
		demoSmestaj.setKuhinja(s.isKuhinja());
		demoSmestaj.setDorucak(s.isDorucak());
		demoSmestaj.setZauzet(s.isZauzet());
			
		BackendServicePortService backServicePortService = new BackendServicePortService();
		BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
		AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
		addSmestajRequest.setSmestaj(demoSmestaj);
		AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
		
		System.out.println("U glavnu bazu azuriran smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
		
		return "redirect:/smestaji/getSviSmestaji";
	}
	
	@RequestMapping(value = "getSviSmestaji/oslobodi/{id}", method = RequestMethod.GET)
    public String free(@PathVariable Long id, ModelMap map){
		
		
		Smestaj s = sm_service.findOne(id);
		s.setZauzet(false);
		sm_service.save(s);
		
		com.xmlws.agent.back.Smestaj demoSmestaj = new com.xmlws.agent.back.Smestaj();
		demoSmestaj.setNaziv(s.getNaziv());
		demoSmestaj.setAgent(null);
		demoSmestaj.setId(s.getId());
		demoSmestaj.setKategorija(s.getKategorija());
		demoSmestaj.setLokacija(s.getLokacija());
		demoSmestaj.setOcena(s.getOcena());
		demoSmestaj.setOpis(s.getOpis());
		demoSmestaj.setTip(s.getTip());
		demoSmestaj.setWifi(s.isWifi());
		demoSmestaj.setTV(s.isTv());
		demoSmestaj.setPolupansion(s.isPolupansion());
		demoSmestaj.setPansion(s.isPansion());
		demoSmestaj.setParking(s.isParking());
		demoSmestaj.setKupatilo(s.isKupatilo());
		demoSmestaj.setKuhinja(s.isKuhinja());
		demoSmestaj.setDorucak(s.isDorucak());
		demoSmestaj.setZauzet(s.isZauzet());
			
		BackendServicePortService backServicePortService = new BackendServicePortService();
		BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
		AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
		addSmestajRequest.setSmestaj(demoSmestaj);
		AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
		
		System.out.println("U glavnu bazu azuriran smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
		
		return "redirect:/smestaji/getSviSmestaji";
	}
	
	@RequestMapping(value = "getSviSmestaji/show/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable Long id, ModelMap map){
		
		ArrayList<Ponuda> svePonude = new ArrayList<Ponuda>();
		ArrayList<Ponuda> mojePonude = new ArrayList<Ponuda>();
		
		Smestaj s = sm_service.findOne(id);
		
		svePonude = (ArrayList<Ponuda>) p_service.findALl();
		for(int i = 0; i < svePonude.size(); i++) {
			if(svePonude.get(i).getSmestaj().equals(s)) {
				mojePonude.add(svePonude.get(i));
			}
			
		}
		

    	map.put("smestaj",sm_service.findOne(id));
    	map.put("slike", sm_service.findOne(id).getMojeSlike());
    	//map.put("ponude", sm_service.findOne(id).getMojePonude());
    	map.put("ponude", mojePonude);
    	
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
		
		demoPonuda.setSmestaj(getSmestajResponse.getSmestaj());
		
		AddPonudaRequest addPonudaRequest = new AddPonudaRequest();
		addPonudaRequest.setPonuda(demoPonuda);
		AddPonudaResponse addPonudaResponse = port.addPonuda(addPonudaRequest);
		
		System.out.println("U glavnu bazu upisana ponuda: " + addPonudaResponse.getPonuda().getCena());
		
		
		//Smestaj s = sm_service.findOne(ponuda.getSmestaj().getId());
		//s.getMojePonude().add(ponuda);
		//sm_service.save(s);
		
		//getted.getPonuda().add(demoPonuda);
		
		//AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
		//addSmestajRequest.setSmestaj(getted);
		//AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
		
		//System.out.println("U glavnoj bazi azuriran smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
		
		
		return "redirect:/smestaji/getSviSmestaji";
	
	}
	
	@RequestMapping(value = "getSveRez/{id}", method = RequestMethod.GET)
    public String showRez(@PathVariable Long id, ModelMap map){
		
		ArrayList<Rezervacija> sveRezervacije = new ArrayList<Rezervacija>();
		ArrayList<Rezervacija> mojeRezervacije = new ArrayList<Rezervacija>();
		
		Ponuda p = p_service.findOne(id);
		
		sveRezervacije = (ArrayList<Rezervacija>) rez_service.findAll();
		
		for(int i = 0; i < sveRezervacije.size(); i++) {
			if(sveRezervacije.get(i).getPonuda().equals(p)) {
				mojeRezervacije.add(sveRezervacije.get(i));
			}
		}
		
		map.put("rezervacije", mojeRezervacije);
		
    	return "rezZaPonudu";
		
    }
	
	@RequestMapping(value = "potvrdiRez/{id}", method = RequestMethod.GET)
    public String acceptRes(@PathVariable Long id, ModelMap map){
		
		Rezervacija r = rez_service.findOne(id);
		ArrayList<Rezervacija> ostaleRezervacije = new ArrayList<Rezervacija>();
		ostaleRezervacije = (ArrayList<Rezervacija>) rez_service.findByPonudaId(r.getPonuda().getId());
		
		r.setPotvrdjeno(false);
		
		for(int i = 0; i < ostaleRezervacije.size(); i++) {
			
			if(ostaleRezervacije.get(i).getId() == r.getId()) {
				ostaleRezervacije.get(i).setPotvrdjeno(true);
				r.setPotvrdjeno(true);
				
				com.xmlws.agent.back.Rezervacija demoRezervacija = new com.xmlws.agent.back.Rezervacija();
				demoRezervacija.setPotvrdjeno(r.isPotvrdjeno());
				demoRezervacija.setId(r.getId());
				demoRezervacija.setDatumRealizacije(r.getDatumRealizacije());
				
				com.xmlws.agent.back.Ponuda demoPonuda = new com.xmlws.agent.back.Ponuda();
				demoPonuda.setBrojKreveta(r.getPonuda().getBrojKreveta());
				demoPonuda.setId(r.getPonuda().getId());
				demoPonuda.setDoDatuma(r.getPonuda().getDoDatuma());
				demoPonuda.setOd(r.getPonuda().getOd());
				
				BackendServicePortService backServicePortService = new BackendServicePortService();
				BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
				
				
				GetSmestajRequest getSmestajRequest = new GetSmestajRequest();
				getSmestajRequest.setNaziv(r.getPonuda().getSmestaj().getNaziv());
				GetSmestajResponse getSmestajResponse = port.getSmestaj(getSmestajRequest);
				
				com.xmlws.agent.back.Smestaj getovaniSmestaj = getSmestajResponse.getSmestaj();
			
				demoPonuda.setSmestaj(getovaniSmestaj);
						
				demoRezervacija.setPonuda(demoPonuda);
				
				com.xmlws.agent.back.RegistrovaniKorisnik demoKorisnik  = new com.xmlws.agent.back.RegistrovaniKorisnik();
				demoKorisnik.setEmail(r.getRegistrovaniKorisnik().getEmail());
				demoKorisnik.setId(r.getRegistrovaniKorisnik().getId());
				demoKorisnik.setIme(r.getRegistrovaniKorisnik().getIme());
				demoKorisnik.setLozinka(r.getRegistrovaniKorisnik().getLozinka());
				demoKorisnik.setPrezime(r.getRegistrovaniKorisnik().getPrezime());
				demoKorisnik.setZabranjen(r.getRegistrovaniKorisnik().isZabranjen());
				
				demoRezervacija.setRegistrovaniKorisnik(demoKorisnik);
				
				rez_service.save(r);
				
				UpdateRezervacijaRequest updateRezervacijaRequest = new UpdateRezervacijaRequest();
				updateRezervacijaRequest.setRezervacija(demoRezervacija);
				UpdateRezervacijaResponse updateRezervacijaResponse = port.updateRezervacija(updateRezervacijaRequest);
				
				
				System.out.println("U glavnu bazu azurirana rezervacija: " + updateRezervacijaResponse.getRezervacija().getId());
						
			}
			else {
				ostaleRezervacije.get(i).setPotvrdjeno(false);
				
				com.xmlws.agent.back.Rezervacija demoRezervacija = new com.xmlws.agent.back.Rezervacija();
				demoRezervacija.setPotvrdjeno(ostaleRezervacije.get(i).isPotvrdjeno());
				demoRezervacija.setId(ostaleRezervacije.get(i).getId());
				demoRezervacija.setDatumRealizacije(ostaleRezervacije.get(i).getDatumRealizacije());
				
				com.xmlws.agent.back.Ponuda demoPonuda = new com.xmlws.agent.back.Ponuda();
				demoPonuda.setBrojKreveta(ostaleRezervacije.get(i).getPonuda().getBrojKreveta());
				demoPonuda.setId(ostaleRezervacije.get(i).getPonuda().getId());
				demoPonuda.setDoDatuma(ostaleRezervacije.get(i).getPonuda().getDoDatuma());
				demoPonuda.setOd(ostaleRezervacije.get(i).getPonuda().getOd());
				
				BackendServicePortService backServicePortService = new BackendServicePortService();
				BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
				
				
				GetSmestajRequest getSmestajRequest = new GetSmestajRequest();
				getSmestajRequest.setNaziv(ostaleRezervacije.get(i).getPonuda().getSmestaj().getNaziv());
				GetSmestajResponse getSmestajResponse = port.getSmestaj(getSmestajRequest);
				
				com.xmlws.agent.back.Smestaj getovaniSmestaj = getSmestajResponse.getSmestaj();
			
				demoPonuda.setSmestaj(getovaniSmestaj);
						
				demoRezervacija.setPonuda(demoPonuda);
				
				com.xmlws.agent.back.RegistrovaniKorisnik demoKorisnik  = new com.xmlws.agent.back.RegistrovaniKorisnik();
				demoKorisnik.setEmail(ostaleRezervacije.get(i).getRegistrovaniKorisnik().getEmail());
				demoKorisnik.setId(ostaleRezervacije.get(i).getRegistrovaniKorisnik().getId());
				demoKorisnik.setIme(ostaleRezervacije.get(i).getRegistrovaniKorisnik().getIme());
				demoKorisnik.setLozinka(ostaleRezervacije.get(i).getRegistrovaniKorisnik().getLozinka());
				demoKorisnik.setPrezime(ostaleRezervacije.get(i).getRegistrovaniKorisnik().getPrezime());
				demoKorisnik.setZabranjen(ostaleRezervacije.get(i).getRegistrovaniKorisnik().isZabranjen());
				
				demoRezervacija.setRegistrovaniKorisnik(demoKorisnik);
				
				rez_service.save(r);
				
				UpdateRezervacijaRequest updateRezervacijaRequest = new UpdateRezervacijaRequest();
				updateRezervacijaRequest.setRezervacija(demoRezervacija);
				UpdateRezervacijaResponse updateRezervacijaResponse = port.updateRezervacija(updateRezervacijaRequest);
				
				System.out.println("U glavnu bazu azurirana rezervacija: " + updateRezervacijaResponse.getRezervacija().getId());

			}
			
		}
			
    	return "redirect:/smestaji/getSveRez/" + r.getPonuda().getId();
		
    }
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public String inbox(ModelMap map) {
		
		map.put("poruke", porukaService.findAll());
		return "inbox";
		
	}
	
	@RequestMapping(value = "/inbox/reply/{id}", method = RequestMethod.GET)
	public String reply(@PathVariable Long id, ModelMap map) {
		
		Poruka p = new Poruka();
		p.setAgent(porukaService.findOne(id).getAgent());
		p.setRegistrovaniKorisnik(porukaService.findOne(id).getRegistrovaniKorisnik());
		p.setProcitana(false);
		p.setSadrzaj("");
		porukaService.save(p);
		
		map.put("poruka", p);
		map.put("agent", porukaService.findOne(id).getAgent());
		map.put("registrovaniKorisnik", porukaService.findOne(id).getRegistrovaniKorisnik());
		map.put("id", id);
		
		return "addPoruka";
		
	}
	
	@RequestMapping(value = "inbox/reply/{id}", method = RequestMethod.POST)
	public String add(@PathVariable Long id, @ModelAttribute("poruka") Poruka por, ModelMap map) {
		
		
		Poruka zaSlanje = porukaService.findOne(por.getId());
		Poruka primljena = porukaService.findOne(id);
		
		primljena.setProcitana(true);
		porukaService.save(primljena);
		
		zaSlanje.setSadrzaj(por.getSadrzaj());
		zaSlanje.setIdPrimljene(id);
		
		porukaService.save(zaSlanje);
		
		return "redirect:/smestaji/inbox";
	}
	
}
