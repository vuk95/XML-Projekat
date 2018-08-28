package com.xmlws.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Ponuda;

@Repository
public interface PonudaRepository extends JpaRepository<Ponuda, Long>{

}
