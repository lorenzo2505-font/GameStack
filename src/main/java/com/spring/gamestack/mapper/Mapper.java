package com.spring.gamestack.mapper;

import com.spring.gamestack.dto.VideogiocoDTO;
import com.spring.gamestack.entity.Videogioco;

public class Mapper {
	
	public static Videogioco convertiInVideogioco(VideogiocoDTO dto) {
		return new Videogioco(dto.getId(), dto.getNome(), dto.getSoftwareHouse(), dto.getPegi(), dto.getGenere(), dto.getVoto()); 
	}
	
	public static VideogiocoDTO convertiInDTO(Videogioco v) {
		return new VideogiocoDTO(v.getId(), v.getNome(), v.getSoftwareHouse(), v.getPegi(), v.getGenere(), v.getVoto());
	}

}
