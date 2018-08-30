package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.dto.AgentFormDTO;

public interface AgentService {

	public Agent findOne(Long id);
	
	public List<Agent> findAll();
	
	public Agent registerNew(AgentFormDTO agentDTO);
}
