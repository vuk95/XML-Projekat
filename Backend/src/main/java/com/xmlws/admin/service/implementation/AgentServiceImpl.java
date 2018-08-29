package com.xmlws.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.dto.AgentFormDTO;
import com.xmlws.admin.repository.AgentRepository;
import com.xmlws.admin.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepo;
	
	@Override
	public List<Agent> findAll() {
		return agentRepo.findAll();
	}

	@Override
	public Agent registerNew(AgentFormDTO agentDTO) {
		Agent agent = new Agent();
		agent.setIme(agentDTO.getIme());
		agent.setPrezime(agentDTO.getPrezime());
		agent.setEmail(agentDTO.getEmail());
		agent.setPoslovniMaticniBroj(agentDTO.getPoslovniMaticniBroj());
		agent.setZabranjen(false);
		agent.setSmestaj(new ArrayList<Smestaj>());
		agent.setLozinka("password");
		
		agentRepo.save(agent);
		
		return agent;
	}

}
