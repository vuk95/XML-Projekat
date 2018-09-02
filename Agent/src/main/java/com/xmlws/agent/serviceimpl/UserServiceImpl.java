package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.repository.UserRepository;
import com.xmlws.agent.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository korisnici;

	@Override
	public List<Korisnik> findAll() {
		return korisnici.findAll();
	}

	@Override
	public Korisnik findById(Long id) {
		return korisnici.getOne(id);
	}

}
