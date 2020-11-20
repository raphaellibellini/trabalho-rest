package br.com.uniacademia.escolabellini.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.uniacademia.escolabellini.modelo.Turma;

public class TurmaDto {
	private Long id;
	
	private String nome;

	private String ensino;			
	
	private int ano;

	private List<AlunoDto> alunos;

	public TurmaDto() {
	}

	public TurmaDto(Turma turma) {
		this.id = turma.getId();
		this.nome = turma.getNome();
		this.ensino = turma.getEnsino().getNome();
		this.ano = turma.getAno();
		this.alunos =  new ArrayList<>();
		this.alunos.addAll(turma.getListaAlunos().stream().map(AlunoDto::new).collect(Collectors.toList()));
	}

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

	public String getEnsino() {
		return ensino;
	}

	public void setEnsino(String ensino) {
		this.ensino = ensino;
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
	
	public static List<TurmaDto> converter(List<Turma> listaTurmas){
		return listaTurmas.stream().map(TurmaDto::new).collect(Collectors.toList());
	}
}
