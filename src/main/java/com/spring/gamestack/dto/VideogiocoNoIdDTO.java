package com.spring.gamestack.dto;

public class VideogiocoNoIdDTO {
	
	private String nome;
	private String softwareHouse; 
	private int pegi; 
	private String genere;
	private double voto; 
	
	public VideogiocoNoIdDTO() {
		super();
	}
	

	public VideogiocoNoIdDTO(String nome, String softwareHouse, int pegi, String genere, double voto) {
		super();
		this.setNome(nome);
		this.setSoftwareHouse(softwareHouse);
		this.setPegi(pegi);
		this.setGenere(genere);
		this.setVoto(voto);  
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

}
