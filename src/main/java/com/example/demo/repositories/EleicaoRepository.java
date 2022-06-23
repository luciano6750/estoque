package com.example.demo.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Eleicao;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Integer>{

	@Query("SELECT obj FROM Eleicao obj where :data >= obj.dataInicio and :data <= obj.dataFim ")
	Page<Eleicao> search(@Param("data") Date data, Pageable pageRequest);
}
