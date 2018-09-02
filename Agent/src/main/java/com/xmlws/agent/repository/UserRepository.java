package com.xmlws.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Korisnik;

@Repository
public interface UserRepository extends JpaRepository<Korisnik, Long>{

}
