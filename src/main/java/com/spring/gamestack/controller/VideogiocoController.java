package com.spring.gamestack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gamestack.dto.ErroreDTO;
import com.spring.gamestack.dto.VideogiocoDTO;
import com.spring.gamestack.dto.VideogiocoNoIdDTO;
import com.spring.gamestack.service.ServiceVideogioco;

@RestController
@RequestMapping(path = "/videogiochi")
public class VideogiocoController {
	
	@Autowired
	private ServiceVideogioco service; 
	
	@PostMapping(path = "/inserimento", consumes = "application/json")
	public boolean inserimento (@RequestBody VideogiocoDTO dto) {
		return service.insert(dto); 
	}
	
	@GetMapping(path = "/elenco", produces = "application/json")
	public List<VideogiocoDTO> elenco(){
		return service.listAll(); 
	}
	
	@GetMapping(path = "/id/{id}", produces = "application/json")
	public VideogiocoDTO id(@PathVariable int id) {
		return service.getVideogioco(id);
	}
	
	@DeleteMapping(path = "/rimozione/{id}", produces = "application/json")
	public VideogiocoDTO rimozione(@PathVariable int id) {
		return service.deleteVideogioco(id); 
	}
	
	@PutMapping(path = "/reinserimento/{id}", consumes = "application/json")
	public VideogiocoDTO reinserimento(@PathVariable int id, @RequestBody VideogiocoNoIdDTO dto) {
		return service.putVideogioco(id, dto); 
	}
	
	@PatchMapping(path = "/nuovoVoto/{id}/{voto}", produces = "application/json")
	public VideogiocoDTO nuovoVoto(@PathVariable int id, @PathVariable double voto) {
		return service.patchVoto(id, voto);
	}
	
	@GetMapping(path = "/softwareHouse/{softwareHouse}", produces = "application/json")
	public List<VideogiocoDTO> softwareHouse(@PathVariable String softwareHouse){
		return service.getBySoftwareHouse(softwareHouse); 
	}
	
	@GetMapping(path = "/pegi/{pegi}", produces = "application/json")
	public List<VideogiocoDTO> pegi(@PathVariable int pegi){
		return service.getByPegi(pegi); 
	}
	
	@GetMapping(path = "/genere/{genere}", produces = "application/json")
	public List<VideogiocoDTO> genere (@PathVariable String genere){
		return service.getByGenere(genere); 
	}
	
	@GetMapping(path = "/voto/{voto}", produces = "application/json")
	public List<VideogiocoDTO> voto (@PathVariable int voto){
		return service.getByVoto(voto);
	}
	
	@GetMapping(path = "/media", produces = "application/json")
	public double media() {
		return service.mediaVoti(); 
	}
	
	@GetMapping(path = "/ordinamentoCrescente", produces = "application/json")
	public List<VideogiocoDTO> ordinamentoCrescente(){
		return service.votiCrescente(); 
	}
	
	@GetMapping(path = "/ordinamentoDecrescente", produces = "application/json")
	public List<VideogiocoDTO> ordinamentoDecrescente(){
		return service.votiDecrescente(); 
	}
	
	@GetMapping(path = "/ordinamentoNome", produces = "application/json")
	public List<VideogiocoDTO> ordinamentoNome(){
		return service.orderByNome(); 
	}
	
	@GetMapping(path = "/ordinamentoGenere", produces = "application/json")
	public List<VideogiocoDTO> ordinamentoGenere(){
		return service.orderByGenere(); 
	}
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> gestoreErrori(RuntimeException ex){
		ErroreDTO dto = new ErroreDTO(ex.getMessage()); 
		
		return new ResponseEntity<ErroreDTO>(dto, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

}

