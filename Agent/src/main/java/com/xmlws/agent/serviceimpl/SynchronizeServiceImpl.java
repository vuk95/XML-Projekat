package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.back.BackendServicePort;
import com.xmlws.agent.back.BackendServicePortService;
import com.xmlws.agent.back.GetAllPonudaRequest;
import com.xmlws.agent.back.GetAllPonudaResponse;
import com.xmlws.agent.back.GetAllRezervacijaRequest;
import com.xmlws.agent.back.GetAllRezervacijaResponse;
import com.xmlws.agent.back.GetAllSmRequest;
import com.xmlws.agent.back.GetAllSmResponse;
import com.xmlws.agent.back.GetAllSmestajRequest;
import com.xmlws.agent.back.GetAllSmestajResponse;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.model.Ponuda;
import com.xmlws.agent.model.Rezervacija;
import com.xmlws.agent.repository.PonudaRepository;
import com.xmlws.agent.repository.RezervacijaRepository;
import com.xmlws.agent.repository.SmestajRepository;
import com.xmlws.agent.service.PonudaService;
import com.xmlws.agent.service.RezervacijaService;
import com.xmlws.agent.service.SmestajService;
import com.xmlws.agent.service.SynchronizeService;

@Service
public class SynchronizeServiceImpl implements SynchronizeService{
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	@Autowired
	private PonudaRepository pRepository;
	
	@Autowired
	private RezervacijaRepository rRepository;
	
	@Override
	public void getAllSmestajByAgent(String email) {
		
		BackendServicePortService backendServicePortService = new BackendServicePortService();
		BackendServicePort port = backendServicePortService.getBackendServicePortSoap11();
		GetAllSmestajRequest getAllSmestajRequest = new GetAllSmestajRequest();
		getAllSmestajRequest.setEmail(email);

		GetAllSmestajResponse getSmestajResponse = port.getAllSmestaj(getAllSmestajRequest);
			
			List<com.xmlws.agent.back.Smestaj> listSmestajDemo = getSmestajResponse.getSmestaj();
			ModelMapper modelMapper =new ModelMapper();
			for(com.xmlws.agent.back.Smestaj smestajDemo : listSmestajDemo) {
				Smestaj smestaj=modelMapper.map(smestajDemo, Smestaj.class);
				/*
				for(Soba soba:smestaj.getSobe()) {
					sobaRepository.save(soba);
					for(Rezervacija rezervacija: soba.getRezervacije()) {
						rezervacijaRepository.save(rezervacija);
					}
				}
				*/
				System.out.println(smestaj.getNaziv());
				smestajRepository.save(smestaj);
			}

	}


	@Override
	public void getAllSmestaj() {
		
		BackendServicePortService backendServicePortService = new BackendServicePortService();
		BackendServicePort port = backendServicePortService.getBackendServicePortSoap11();
		GetAllSmRequest request = new GetAllSmRequest();
		request.setEmail("nebitno");

		GetAllSmResponse response = port.getAllSm(request);
		
		List<com.xmlws.agent.back.Smestaj> listSmestajDemo = response.getSmestaj();
		ModelMapper modelMapper =new ModelMapper();
		for(com.xmlws.agent.back.Smestaj smestajDemo : listSmestajDemo) {
			Smestaj smestaj=modelMapper.map(smestajDemo, Smestaj.class);
			System.out.println(smestaj.getNaziv());
			smestajRepository.save(smestaj);
		}

	}


	@Override
	public void getAllPonuda() {
		
		BackendServicePortService backendServicePortService = new BackendServicePortService();
		BackendServicePort port = backendServicePortService.getBackendServicePortSoap11();
		GetAllPonudaRequest request = new GetAllPonudaRequest();
		request.setId("nebitno");

		GetAllPonudaResponse response = port.getAllPonuda(request);
		
		List<com.xmlws.agent.back.Ponuda> listPonudaDemo = response.getPonuda();
		ModelMapper modelMapper =new ModelMapper();
		
		for(com.xmlws.agent.back.Ponuda ponudaDemo : listPonudaDemo) {
			Ponuda p = modelMapper.map(ponudaDemo, Ponuda.class);
			System.out.println(p.getCena());
			pRepository.save(p);
			
		}
	}


	@Override
	public void getAllRezervacija() {
		
		
		BackendServicePortService backendServicePortService = new BackendServicePortService();
		BackendServicePort port = backendServicePortService.getBackendServicePortSoap11();
		GetAllRezervacijaRequest request = new GetAllRezervacijaRequest();
		request.setId("nebitno");

		GetAllRezervacijaResponse response = port.getAllRezervacija(request);
		
		List<com.xmlws.agent.back.Rezervacija> listRezervacijaDemo = response.getRezervacija();
		ModelMapper modelMapper =new ModelMapper();
		
		for(com.xmlws.agent.back.Rezervacija rezervacijaDemo : listRezervacijaDemo) {
			Rezervacija r = modelMapper.map(rezervacijaDemo, Rezervacija.class);
			System.out.println(r.getId());
			rRepository.save(r);
			
		}
		
	}
  }	
