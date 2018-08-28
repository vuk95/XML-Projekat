package com.xmlws.admin.converters;

import org.springframework.stereotype.Component;

import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.dto.PonudaDTO;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;

@Component
public class PonudaToPonudaDTO  implements  Converter<Ponuda, PonudaDTO> {

	@Override
	public PonudaDTO convert(Ponuda source) {
		
		if(source == null) {
			return null;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		PonudaDTO ponudaDTO = modelMapper.map(source,PonudaDTO.class);
		
		return ponudaDTO;
	}

	
	public List<PonudaDTO> convert(List<Ponuda> source) {
		
		List<PonudaDTO> ponudaDTO = new ArrayList<PonudaDTO>();
		for(Ponuda ponuda:source) {
			ponudaDTO.add(convert(ponuda));
		}
		
		return ponudaDTO;
	}
		
		
}
