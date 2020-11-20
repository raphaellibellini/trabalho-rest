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

import br.com.uniacademia.escolabellini.controller.dto.TurmaDto;
import br.com.uniacademia.escolabellini.controller.form.AtualizacaoTurmaForm;
import br.com.uniacademia.escolabellini.controller.form.TurmaForm;
import br.com.uniacademia.escolabellini.modelo.Turma;
import br.com.uniacademia.escolabellini.repository.AlunoRepository;
import br.com.uniacademia.escolabellini.repository.EnsinoRepository;
import br.com.uniacademia.escolabellini.repository.TurmaRepository;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	EnsinoRepository ensinoRepo;
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@PostMapping
	@Transactional
	public ResponseEntity<TurmaDto> cadastrar(@RequestBody TurmaForm form, UriComponentsBuilder uriBuilder){
		
		Turma turma = form.converter(ensinoRepo, alunoRepo);
		turmaRepo.save(turma);
		
		URI uri = uriBuilder.path("/turmas/{id}").buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).body(new TurmaDto(turma));
	}
	
	@GetMapping
	public List<TurmaDto> listarTodos (String nomeEnsino) {
		if (nomeEnsino == null) {
		List<Turma> listaTurmas = turmaRepo.findAll();
		return TurmaDto.converter(listaTurmas);
		} else {
			List<Turma> listaTurmas = turmaRepo.findByEnsino_Nome(nomeEnsino);
			return TurmaDto.converter(listaTurmas);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TurmaDto> listarPorId(@PathVariable Long id) {
		
		Optional<Turma> turma = turmaRepo.findById(id);
		if(turma.isPresent()) {
			return ResponseEntity.ok(new TurmaDto(turma.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional 
	public ResponseEntity<TurmaDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoTurmaForm form) {
		Optional<Turma> optional = turmaRepo.findById(id);
		if(optional.isPresent()) {
			Turma turma = form.atualizar(id, turmaRepo, ensinoRepo);
			return ResponseEntity.ok(new TurmaDto(turma));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Turma> turma = turmaRepo.findById(id);
		if(turma.isPresent()) {
			turmaRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
