package com.xmlws.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmlws.admin.backend.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long>{

	public List<Komentar> findByOdobrenFalse();
}
