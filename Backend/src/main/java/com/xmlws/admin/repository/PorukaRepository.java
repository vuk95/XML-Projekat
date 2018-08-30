package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long> {

}
