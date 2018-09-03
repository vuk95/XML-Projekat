package com.xmlws.admin.service;

import com.xmlws.admin.backend.Ocena;
import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.backend.Smestaj;

public interface OcenaService {

	public Ocena novaOcena(int ocena, Smestaj smestaj, RegistrovaniKorisnik korisnik);
}
