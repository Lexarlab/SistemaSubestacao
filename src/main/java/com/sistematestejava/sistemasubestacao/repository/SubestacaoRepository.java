package com.sistematestejava.sistemasubestacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sistematestejava.sistemasubestacao.model.Subestacao;

public interface SubestacaoRepository extends JpaRepository<Subestacao, Long> {
	
	public List <Subestacao> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
