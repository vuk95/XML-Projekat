package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long> {

}
