package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Eleicao;
import com.example.demo.repositories.EleicaoRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class EleicaoService {
	@Autowired
	private EleicaoRepository repo;
	
	public Eleicao find(Integer id) {
		Optional<Eleicao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Eleição nao encontrada! Id: "+id+", Tipo: "+Eleicao.class.getName()));
	}
}