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

import br.com.uniacademia.escolabellini.controller.dto.AlunoDto;
import br.com.uniacademia.escolabellini.controller.form.AlunoForm;
import br.com.uniacademia.escolabellini.controller.form.AtualizacaoAlunoForm;
import br.com.uniacademia.escolabellini.modelo.Aluno;
import br.com.uniacademia.escolabellini.repository.AlunoRepository;
import br.com.uniacademia.escolabellini.repository.TurmaRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder){
		Aluno aluno = form.converter(turmaRepo);
		alunoRepo.save(aluno);
		
		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getMatricula()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}
	
	@GetMapping
	public List<AlunoDto> listarTodos(){
		return AlunoDto.converter(alunoRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> listarPorId(@PathVariable Long id) {
		
		Optional<Aluno> aluno = alunoRepo.findById(id);
		if(aluno.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(aluno.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional 
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoAlunoForm form) {
		Optional<Aluno> optional = alunoRepo.findById(id);
		if(optional.isPresent()) {
			Aluno aluno = form.atualizar(id, alunoRepo, turmaRepo);
			return ResponseEntity.ok(new AlunoDto(aluno));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Aluno> aluno = alunoRepo.findById(id);
		if(aluno.isPresent()) {
			alunoRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
