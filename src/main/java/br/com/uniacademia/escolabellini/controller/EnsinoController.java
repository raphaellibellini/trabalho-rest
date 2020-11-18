package br.com.uniacademia.escolabellini.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.uniacademia.escolabellini.modelo.Ensino;
import br.com.uniacademia.escolabellini.repository.EnsinoRepository;

@RestController
@RequestMapping("/ensinos")
public class EnsinoController {	
	
	@Autowired	
	EnsinoRepository ensinoRepo;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Ensino> cadastrar(@RequestBody Ensino ensino, UriComponentsBuilder uriBuilder){
		
		ensinoRepo.save(ensino);
		URI uri = uriBuilder.path("/ensinos/{id}").buildAndExpand(ensino.getId()).toUri();
		return ResponseEntity.created(uri).body(ensino);
	}
	
}
