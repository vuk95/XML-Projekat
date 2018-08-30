package com.xmlws.admin.service;

import com.xmlws.admin.backend.Ponuda;

public interface OfferSoapService {
	
	Ponuda save(Ponuda p);
	Ponuda findOne(Long id);
}
