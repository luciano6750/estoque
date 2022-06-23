package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cargo;
import com.example.demo.domain.Eleicao;
import com.example.demo.dto.CargoDTO;
import com.example.demo.dto.CargoNewDTO;
import com.example.demo.repositories.CargoRepository;
import com.example.demo.repositories.EleicaoRepository;
import com.example.demo.services.exception.DataIntegrityException;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repo;
	@Autowired
	private EleicaoRepository eleicaoRepository;

	public Cargo find(Integer id) {
		Optional<Cargo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cargos nao encontrados! Id: " + id + ", Tipo: " + Cargo.class.getName()));
	}

	public Cargo insert(Cargo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cargo update(Cargo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um usúario que participou de alguma votação");
		}
	}

	public Page<Cargo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public List<Cargo> findAll() {
		return repo.findAll();
	}

	public Cargo fromDTO(CargoDTO obj) {
		return new Cargo(obj.getId(), obj.getNomeCargo(),null);
	}
	
	
	public Cargo fromDTO(CargoNewDTO obj) {
		Optional<Eleicao> eleicao = eleicaoRepository.findById(obj.getEleicaoId());
		return new Cargo(obj.getId(), obj.getNomeCargo(),eleicao.get());
	}
}
