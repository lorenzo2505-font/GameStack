package com.spring.gamestack.dao;

import java.util.List;

import com.spring.gamestack.entity.Videogioco;

public interface DAOVideogioco {
	
	public boolean insert (Videogioco videogioco); 
	public List<Videogioco> listAll();
	public Videogioco getVideogioco(int id); 
	public Videogioco deleteVideogioco(int id); 
	public Videogioco putVideogioco(int id, String newNome, String newSoftwareHouse, int newPegi, String newGenere, double newVoto); 
	public Videogioco patchVoto(int id, double voto); 
	
	

}
