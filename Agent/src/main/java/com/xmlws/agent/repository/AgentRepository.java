package com.xmlws.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
