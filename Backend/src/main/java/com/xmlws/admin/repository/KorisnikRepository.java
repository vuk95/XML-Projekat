package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmlws.admin.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	public Korisnik findByEmail(String email);
}
