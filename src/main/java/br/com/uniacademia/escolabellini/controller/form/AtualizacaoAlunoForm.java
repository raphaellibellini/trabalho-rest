package br.com.uniacademia.escolabellini.controller.form;

import br.com.uniacademia.escolabellini.modelo.Aluno;
import br.com.uniacademia.escolabellini.modelo.Turma;
import br.com.uniacademia.escolabellini.repository.AlunoRepository;
import br.com.uniacademia.escolabellini.repository.TurmaRepository;

public class AtualizacaoAlunoForm {
	private String nome;
	
	private int anoNascimento;
	
	private String nomeTurma;

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
	
	public Aluno atualizar(Long id, AlunoRepository alunoRepo, TurmaRepository turmaRepo) {
		Aluno aluno = alunoRepo.getOne(id);
		aluno.setNome(this.nome);
		aluno.setAnoNascimento(this.anoNascimento);
		Turma turmaEnt = turmaRepo.findByNome(this.nomeTurma);
		aluno.setTurma(turmaEnt);
		return aluno;
	}
}
