package br.com.uniacademia.escolabellini.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.uniacademia.escolabellini.modelo.Aluno;


public class AlunoDto {
	private Long matricula;
	
	private String nome;
	
	private int anoNascimento;
	
	private Long turmaId;

	public AlunoDto() {
	}

	public AlunoDto(Aluno aluno) {
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.anoNascimento = aluno.getAnoNascimento();
		this.turmaId = aluno.getTurma().getId();
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Long getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}
	
	public static List<AlunoDto> converter(List<Aluno> listaAlunos){
		return listaAlunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
}
