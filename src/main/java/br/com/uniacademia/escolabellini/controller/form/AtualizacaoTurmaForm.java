package br.com.uniacademia.escolabellini.controller.form;

import br.com.uniacademia.escolabellini.modelo.Ensino;
import br.com.uniacademia.escolabellini.modelo.Turma;
import br.com.uniacademia.escolabellini.repository.EnsinoRepository;
import br.com.uniacademia.escolabellini.repository.TurmaRepository;

public class AtualizacaoTurmaForm {
	
	private String nome;

	private String ensino;			
	
	private int ano;

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
	
	public Turma atualizar(Long id, TurmaRepository turmaRepo, EnsinoRepository ensinoRepo) {
		Turma turma = turmaRepo.getOne(id);
		turma.setNome(this.nome);
		turma.setAno(this.ano);
		Ensino ensinoEnt = ensinoRepo.findByNome(this.ensino);
		turma.setEnsino(ensinoEnt);
		return turma;
	}
}
