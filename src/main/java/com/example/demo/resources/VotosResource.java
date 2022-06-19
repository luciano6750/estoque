package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Votos;
import com.example.demo.services.VotosService;

@RestController
@RequestMapping(value="/votos")
public class VotosResource {
	@Autowired
	private VotosService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Votos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
