package br.com.uniacademia.escolabellini.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.uniacademia.escolabellini.controller.dto.EnsinoDto;
import br.com.uniacademia.escolabellini.controller.form.AtualizacaoEnsinoForm;
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
	
	@GetMapping
	public List<EnsinoDto> listarTodos(){
		
		return EnsinoDto.converter(ensinoRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnsinoDto> listarPorId(@PathVariable Long id){
		Optional<Ensino> ensino = ensinoRepo.findById(id);
		if(ensino.isPresent()) {
			return ResponseEntity.ok(new EnsinoDto(ensino.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody AtualizacaoEnsinoForm form){		
		
		Optional<Ensino> optional = ensinoRepo.findById(id);
		if(optional.isPresent()) {	
			Ensino ensino = form.atualizar(id, ensinoRepo);	
			return ResponseEntity.ok(ensino);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id){
		Optional<Ensino> ensino = ensinoRepo.findById(id);
		if(ensino.isPresent()) {
			ensinoRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
