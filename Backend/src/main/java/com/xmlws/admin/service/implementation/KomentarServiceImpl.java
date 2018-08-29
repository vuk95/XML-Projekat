package com.xmlws.admin.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Komentar;
import com.xmlws.admin.repository.KomentarRepository;
import com.xmlws.admin.service.KomentarService;

@Service
public class KomentarServiceImpl implements KomentarService {

	@Autowired
	private KomentarRepository komentarRepo;
	
	@Override
	public List<Komentar> nadjiNeodobrene() {
		return komentarRepo.findByOdobrenFalse();
	}

	@Override
	public Komentar findById(Long id) {
		Optional<Komentar> komentar = komentarRepo.findById(id);
		if(komentar.isPresent()) {
			return komentar.get();
		} else {
			return null;
		}
	}

	@Override
	public Komentar save(Komentar komentar) {
		return komentarRepo.save(komentar);
	}

}
