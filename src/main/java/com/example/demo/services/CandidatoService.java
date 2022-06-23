package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Candidato;
import com.example.demo.domain.Cargo;
import com.example.demo.dto.CandidatoDTO;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.repositories.CargoRepository;
import com.example.demo.services.exception.DataIntegrityException;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repo;
	@Autowired
	private CargoRepository cargoRepository;

	public Candidato find(Integer id) {
		Optional<Candidato> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Candidatos nao encontrados! Id: " + id + ", Tipo: " + Candidato.class.getName()));
	}

	public Candidato insert(Candidato obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Candidato update(Candidato obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Candidato que participou de alguma eleição");
		}
	}

	public Page<Candidato> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public List<Candidato> findAll() {
		return repo.findAll();
	}

	public Candidato fromDTO(CandidatoDTO obj) {
		Optional<Cargo> cargo = cargoRepository.findById(obj.getCargoId());
		return new Candidato(obj.getId(),obj.getNome(),obj.getFotoUrl(),cargo.get());
	}
	
}
