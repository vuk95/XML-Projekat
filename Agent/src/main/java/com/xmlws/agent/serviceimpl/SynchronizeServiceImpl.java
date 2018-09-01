package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.back.BackendServicePort;
import com.xmlws.agent.back.BackendServicePortService;
import com.xmlws.agent.back.GetAllSmestajRequest;
import com.xmlws.agent.back.GetAllSmestajResponse;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.repository.SmestajRepository;
import com.xmlws.agent.service.SynchronizeService;

@Service
public class SynchronizeServiceImpl implements SynchronizeService{
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	
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

}
