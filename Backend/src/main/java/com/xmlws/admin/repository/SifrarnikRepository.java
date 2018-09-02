package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Sifrarnik;

@Repository
public interface SifrarnikRepository extends JpaRepository<Sifrarnik, Long> {

}
