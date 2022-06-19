package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Eleicao;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Integer>{

}
