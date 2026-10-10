package com.spring.gamestack.dto;

import java.util.Objects;

public class VideogiocoDTO {
	
	private int id; 
	private String nome;
	private String softwareHouse; 
	private int pegi; 
	private String genere;
	private double voto;
	
	public VideogiocoDTO() {
		super();
	}
	
	public VideogiocoDTO(int id, String nome, String softwareHouse, int pegi, String genere, double voto) {
		super();
		this.setId(id);
		this.setNome(nome);
		this.setSoftwareHouse(softwareHouse);
		this.setPegi(pegi);
		this.setGenere(genere);
		this.setVoto(voto);  
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		if(id < 0) {
			throw new RuntimeException("l'id non può avere valore negativo"); 
		}
		
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		if(nome.equals("")) {
			throw new RuntimeException("inserire un nome valido"); 
		}
		
		this.nome = nome;
	}

	public String getSoftwareHouse() {
		return softwareHouse;
	}

	public void setSoftwareHouse(String softwareHouse) {
		
		if(softwareHouse.equals("")) {
			throw new RuntimeException("inserire un nome valido"); 
		}
		
		this.softwareHouse = softwareHouse;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		
		if(pegi != 3 && pegi != 7 && pegi != 12 && pegi != 16 && pegi != 18) {
			throw new RuntimeException("inserire un pegi valido: [3, 7, 12, 16, 18]"); 
		}
		
		this.pegi = pegi;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		
		if(genere.equals("")) {
			throw new RuntimeException("inserire un nome valido"); 
		}
		
		this.genere = genere;
	}
	
	public double getVoto() {
		return voto;
	}

	public void setVoto(double voto) {
		if(voto < 0 || voto > 10) {
			throw new RuntimeException("il videogioco deve avere una valutazione compresa tra 0 e 10");
		}
		this.voto = voto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideogiocoDTO other = (VideogiocoDTO) obj;
		return id == other.id;
	}
	
	
	
	
	
	

}
