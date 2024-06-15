package com.sistematestejava.sistemasubestacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sistematestejava.sistemasubestacao.model.RedeMT;

public interface RedeMTRepository extends JpaRepository<RedeMT, Long>{
	
	public List <RedeMT> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
