package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Smestaj;

@Repository
public interface SmRepository extends JpaRepository<Smestaj, Long>{

}