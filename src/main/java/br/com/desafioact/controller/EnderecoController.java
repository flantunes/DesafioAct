package br.com.desafioact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioact.model.Endereco;
import br.com.desafioact.repository.EnderecoRepository;


@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public ResponseEntity<List<Endereco>> getAll() {
		return ResponseEntity.ok(enderecoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable long id) {
		return enderecoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@PostMapping
	public ResponseEntity<Endereco> post(@RequestBody Endereco endereco){
	return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
	}
}
