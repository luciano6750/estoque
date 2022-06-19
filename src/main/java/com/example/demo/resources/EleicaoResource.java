package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Eleicao;
import com.example.demo.services.EleicaoService;

@RestController
@RequestMapping(value="/eleicao")
public class EleicaoResource {
	@Autowired
	private EleicaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Eleicao> buscar(@PathVariable Integer id) {
		Eleicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
