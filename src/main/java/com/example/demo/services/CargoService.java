package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cargo;
import com.example.demo.dto.CargoDTO;
import com.example.demo.repositories.CargoRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repo;
	
	public Cargo find(Integer id) {
		Optional<Cargo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cargo nao encontrado! Id: "+id+", Tipo: "+Cargo.class.getName()));
	}
	
	public Cargo insert(Cargo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Cargo> findAll(){
		return repo.findAll();
	}
	
	public Page<Cargo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}
	
}

