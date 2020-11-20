package br.com.uniacademia.escolabellini.controller.form;

import br.com.uniacademia.escolabellini.modelo.Aluno;
import br.com.uniacademia.escolabellini.modelo.Turma;
import br.com.uniacademia.escolabellini.repository.TurmaRepository;

public class AlunoForm {
	private Long matricula;
	
	private String nome;
	
	private int anoNascimento;
	
	private String nomeTurma;

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
	
	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Aluno converter(TurmaRepository turmaRepo) {
		Turma turma = turmaRepo.findByNome(nomeTurma);
		return new Aluno(matricula, nome, anoNascimento, turma);
	}
}
