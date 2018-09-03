package com.xmlws.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Ocena;
import com.xmlws.admin.backend.Smestaj;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

	public List<Ocena> findBySmestaj(Smestaj smestaj);
	
}
