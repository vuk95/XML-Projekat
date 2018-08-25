package com.xmlws.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.ws.model.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long> {

}
