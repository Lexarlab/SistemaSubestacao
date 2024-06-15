package com.sistematestejava.sistemasubestacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistematestejava.sistemasubestacao.model.Subestacao;
import com.sistematestejava.sistemasubestacao.repository.SubestacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subestacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubestacaoController {
	
	@Autowired
	private SubestacaoRepository subestacaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Subestacao>> getAll(){
		return ResponseEntity.ok(subestacaoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subestacao> getById(@PathVariable Long id) {
		return subestacaoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Subestacao>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(subestacaoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Subestacao> post(@Valid @RequestBody Subestacao subestacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subestacaoRepository.save(subestacao));
	}
	
	@PutMapping
	public ResponseEntity<Subestacao> put(@Valid @RequestBody Subestacao subestacao){
        return subestacaoRepository.findById(subestacao.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
            .body(subestacaoRepository.save(subestacao)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Subestacao> subestacao = subestacaoRepository.findById(id);

		if (subestacao.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		subestacaoRepository.deleteById(id);
	}

}
