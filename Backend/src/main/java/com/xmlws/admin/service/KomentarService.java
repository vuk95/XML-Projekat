package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.Komentar;

public interface KomentarService {

	public List<Komentar> nadjiNeodobrene();
	
	public Komentar findById(Long id);
	
	public Komentar save(Komentar komentar);
}
