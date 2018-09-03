package com.xmlws.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Smestaj;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long>{

	List<Smestaj> findByAgent(Korisnik ag);

}
