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

import com.sistematestejava.sistemasubestacao.model.RedeMT;
import com.sistematestejava.sistemasubestacao.repository.RedeMTRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/redeMT")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RedeMTController {
	
	@Autowired
	private RedeMTRepository redeMTRepository;
	
	@GetMapping
	public ResponseEntity<List<RedeMT>> getAll(){
		return ResponseEntity.ok(redeMTRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RedeMT> getById(@PathVariable Long id) {
		return redeMTRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<RedeMT>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(redeMTRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<RedeMT> post(@Valid @RequestBody RedeMT redeMT) {
		return ResponseEntity.status(HttpStatus.CREATED).body(redeMTRepository.save(redeMT));
	}
	
	@PutMapping
	public ResponseEntity<RedeMT> put(@Valid @RequestBody RedeMT redeMT){
        return redeMTRepository.findById(redeMT.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
            .body(redeMTRepository.save(redeMT)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<RedeMT> subestacao = redeMTRepository.findById(id);

		if (subestacao.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		redeMTRepository.deleteById(id);
	}

}
