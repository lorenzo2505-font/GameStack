package com.spring.gamestack.service;

import java.util.List;

import com.spring.gamestack.dto.VideogiocoDTO;
import com.spring.gamestack.dto.VideogiocoNoIdDTO;

public interface ServiceVideogioco {
	
	// METODI DAO
	public boolean insert(VideogiocoDTO dto);
	public List<VideogiocoDTO> listAll();
	public VideogiocoDTO getVideogioco(int id); 
	public VideogiocoDTO deleteVideogioco(int id);
	public VideogiocoDTO putVideogioco(int id, VideogiocoNoIdDTO dto);
	public VideogiocoDTO patchVoto(int id, double voto); 
	
	// ALTRI METODI
	public List<VideogiocoDTO> getBySoftwareHouse (String softwareHouse); 
	public List<VideogiocoDTO> getByPegi(int pegi); 
	public List<VideogiocoDTO> getByGenere(String genere);
	public List<VideogiocoDTO> getByVoto(int voto); 
	
	public double mediaVoti(); 
	
	public List<VideogiocoDTO> votiCrescente();
	public List<VideogiocoDTO> votiDecrescente(); 
	public List<VideogiocoDTO> orderByNome(); 
	public List<VideogiocoDTO> orderByGenere(); 
	
	
	
	

}
