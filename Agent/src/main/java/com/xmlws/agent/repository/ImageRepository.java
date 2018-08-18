package com.xmlws.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.agent.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
