package br.com.uniacademia.escolabellini.controller.form;

import java.util.List;

import br.com.uniacademia.escolabellini.controller.dto.AlunoDto;
import br.com.uniacademia.escolabellini.modelo.Aluno;
import br.com.uniacademia.escolabellini.modelo.Ensino;
import br.com.uniacademia.escolabellini.modelo.Turma;
import br.com.uniacademia.escolabellini.repository.AlunoRepository;
import br.com.uniacademia.escolabellini.repository.EnsinoRepository;

public class TurmaForm {
	private Long id;
	
	private String nome;

	private String nomeEnsino;	
	
	private int ano;

	private List<AlunoDto> alunos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeEnsino() {
		return nomeEnsino;
	}

	public void setNomeEnsino(String nomeEnsino) {
		this.nomeEnsino = nomeEnsino;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<AlunoDto> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoDto> alunos) {
		this.alunos = alunos;
	}
	
	public Turma converter(EnsinoRepository ensinoRepo, AlunoRepository alunoRepo) {
		Ensino ensino = ensinoRepo.findByNome(nomeEnsino);
		List<Aluno> listaAlunos = alunoRepo.findAll();
		return new Turma(id, nome, ensino, ano, listaAlunos);
	}
}
