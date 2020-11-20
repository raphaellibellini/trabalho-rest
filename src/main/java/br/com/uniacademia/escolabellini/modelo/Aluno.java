package br.com.uniacademia.escolabellini.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricula;
	
	private String nome;
	
	private int anoNascimento;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;

	public Aluno() {
	}

	public Aluno(Long matricula, String nome, int anoNascimento, Turma turma) {
		this.matricula = matricula;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.turma = turma;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
