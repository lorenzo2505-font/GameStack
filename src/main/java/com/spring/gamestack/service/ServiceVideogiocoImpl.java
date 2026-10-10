package com.spring.gamestack.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gamestack.dao.DAOVideogioco;
import com.spring.gamestack.dto.VideogiocoDTO;
import com.spring.gamestack.dto.VideogiocoNoIdDTO;
import com.spring.gamestack.entity.Videogioco;
import com.spring.gamestack.mapper.Mapper;

@Service
public class ServiceVideogiocoImpl implements ServiceVideogioco{
	
	@Autowired
	private DAOVideogioco dao;

	@Override
	public boolean insert(VideogiocoDTO dto) {
		// TODO Auto-generated method stub
		Videogioco v = Mapper.convertiInVideogioco(dto); 
		
		return dao.insert(v); 
	}

	@Override
	public List<VideogiocoDTO> listAll() {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.map(v -> Mapper.convertiInDTO(v))
				.collect(Collectors.toList());
		
		return dtos; 
	}

	@Override
	public VideogiocoDTO getVideogioco(int id) {
		// TODO Auto-generated method stub
		Videogioco v = dao.getVideogioco(id); 
		
		if(v == null) {
			return null; 
		}
		
		return Mapper.convertiInDTO(v); 
	}

	@Override
	public VideogiocoDTO deleteVideogioco(int id) {
		// TODO Auto-generated method stub
		Videogioco v = dao.deleteVideogioco(id); 
		
		if(v == null) {
			return null; 
		}
		
		return Mapper.convertiInDTO(v); 
	}

	@Override
	public VideogiocoDTO putVideogioco(int id, VideogiocoNoIdDTO dto) {
		// TODO Auto-generated method stub
		Videogioco v = dao.putVideogioco(id, dto.getNome(), dto.getSoftwareHouse(), dto.getPegi(), dto.getGenere(), dto.getVoto()); 
		
		if(v == null) {
			return null; 
		}
		
		return Mapper.convertiInDTO(v); 
	}

	@Override
	public VideogiocoDTO patchVoto(int id, double voto) {
		// TODO Auto-generated method stub
		Videogioco v = dao.patchVoto(id, voto); 
		
		if(v == null) {
			return null; 
		}
		
		return Mapper.convertiInDTO(v); 
	}

	@Override
	public List<VideogiocoDTO> getBySoftwareHouse(String softwareHouse) {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.filter(v -> v.getSoftwareHouse().equalsIgnoreCase(softwareHouse))
				.map(v -> Mapper.convertiInDTO(v))
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> getByPegi(int pegi) {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.filter(v -> v.getPegi() == pegi)
				.map(v -> Mapper.convertiInDTO(v))
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> getByGenere(String genere) {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.filter(v -> v.getGenere().equalsIgnoreCase(genere))
				.map(v -> Mapper.convertiInDTO(v))
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> getByVoto(int voto) {
		// TODO Auto-generated method stub
		if (voto < 0 || voto > 10) {
			return new ArrayList<VideogiocoDTO>(); 
		}
		
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.filter(v -> (v.getVoto() >= voto && v.getVoto() < voto + 1))
				.map(v -> Mapper.convertiInDTO(v))
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public double mediaVoti() {
		// TODO Auto-generated method stub
		List<Videogioco> lista = dao.listAll();
		int size = lista.size(); 
		
		if(size == 0) {
			return 0; 
		}
		
		double total = lista.stream()
				.map(v -> v.getVoto())
				.reduce(0.0, (v1, v2) -> v1 + v2);
		
		double media = total / size; 
		
		return media; 
		
		
	}

	@Override
	public List<VideogiocoDTO> votiCrescente() {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.map(v -> Mapper.convertiInDTO(v))
				.sorted(Comparator.comparingDouble(t -> t.getVoto()))
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> votiDecrescente() {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.map(v -> Mapper.convertiInDTO(v))
				.sorted(Comparator.comparingDouble(t -> ((VideogiocoDTO) t).getVoto()).reversed())
				.collect(Collectors.toList()); 
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> orderByNome() {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.map(v -> Mapper.convertiInDTO(v))
				.sorted((v1, v2) -> (v1.getNome().compareTo(v2.getNome())))
				.collect(Collectors.toList());
		
		return dtos; 
	}

	@Override
	public List<VideogiocoDTO> orderByGenere() {
		// TODO Auto-generated method stub
		List<VideogiocoDTO> dtos = dao.listAll().stream()
				.map(v -> Mapper.convertiInDTO(v))
				.sorted((v1, v2) -> (v1.getGenere().compareTo(v2.getGenere())))
				.collect(Collectors.toList());
		
		return dtos; 
	} 
	
	
	

}
