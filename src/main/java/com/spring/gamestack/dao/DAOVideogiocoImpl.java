package com.spring.gamestack.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.gamestack.entity.Videogioco;

@Repository
public class DAOVideogiocoImpl implements DAOVideogioco {
	
	private Map<Integer, Videogioco> mappa = new HashMap<>();

	public DAOVideogiocoImpl() {
		super();
		
	}

	@Override
	public boolean insert(Videogioco videogioco) {
		// TODO Auto-generated method stub
		if(mappa.containsKey(videogioco.getId())) {
			return false;
		}
		
		mappa.put(videogioco.getId(), videogioco); 
		
		return true; 
		
	}

	@Override
	public List<Videogioco> listAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Videogioco> (mappa.values());
	}

	@Override
	public Videogioco getVideogioco(int id) {
		// TODO Auto-generated method stub
		if(! mappa.containsKey(id)) {
			return null;
		}
		
		return mappa.get(id); 
		
		
	}

	@Override
	public Videogioco deleteVideogioco(int id) {
		// TODO Auto-generated method stub
		if(! mappa.containsKey(id)) {
			return null;
		}
		
		return mappa.remove(id); 
	}

	@Override
	public Videogioco putVideogioco(int id, String newNome, String newSoftwareHouse, int newPegi, String newGenere, double newVoto) {
		// TODO Auto-generated method stub
		Videogioco v = this.getVideogioco(id);
		
		if(v == null) {
			return null; 
		}
		
		v.setNome(newNome);
		v.setSoftwareHouse(newSoftwareHouse);
		v.setPegi(newPegi);
		v.setGenere(newGenere);
		v.setVoto(newVoto);
		
		return v; 
	}

	@Override
	public Videogioco patchVoto(int id, double voto) {
		// TODO Auto-generated method stub
		Videogioco v = this.getVideogioco(id); 
		
		if(v == null) {
			return null; 
		}
		
		v.setVoto(voto); 
		
		return v; 
	}
	
	
	
	
	
	

}
