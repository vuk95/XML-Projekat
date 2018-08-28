package com.xmlws.admin.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.xmlws.admin.backend.Rezervacija;
import com.xmlws.admin.dto.RezervacijaDTO;

@Component
public class RezervacijaToRezervacijaDTO implements  Converter<Rezervacija, RezervacijaDTO>{

	@Override
	public RezervacijaDTO convert(Rezervacija source) {
		
		if(source == null) {
			return null;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		RezervacijaDTO rezervacijaDTO = modelMapper.map(source,RezervacijaDTO.class);
		
		return rezervacijaDTO;
	
	}
	
	public List<RezervacijaDTO> convert(List<Rezervacija> source) {
		
		List<RezervacijaDTO> rezervacijaDTO = new ArrayList<RezervacijaDTO>();
		for(Rezervacija rezervacija:source) {
			rezervacijaDTO.add(convert(rezervacija));
		}
		
		return rezervacijaDTO;
	}

}
