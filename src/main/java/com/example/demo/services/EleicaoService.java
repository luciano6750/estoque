package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Page<Eleicao> search(String dataS ,Integer page, Integer linesPerPage, String orderBy, String direction) {
		Date data = Tools.StringToDate(dataS);
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.search(data,pageRequest);
	}
}