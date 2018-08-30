package com.xmlws.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmlws.admin.backend.Poruka;
import com.xmlws.admin.repository.PorukaRepository;
import com.xmlws.admin.service.PorukaService;

@Transactional
@Service
public class PorukaServiceImpl implements PorukaService {

	@Autowired
	private PorukaRepository repository;
	
	@Override
	public Poruka findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Poruka> findAll() {
		return repository.findAll();
	}

	@Override
	public Poruka save(Poruka p) {
		return repository.save(p);
	}

	
	
}
