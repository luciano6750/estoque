package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Votos;
import com.example.demo.repositories.VotosRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class VotosService {
	@Autowired
	private VotosRepository repo;
	
	public Votos find(Integer id) {
		Optional<Votos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Votos nao encontrados! Id: "+id+", Tipo: "+Votos.class.getName()));
	}
}