package br.com.uniacademia.escolabellini.controller.form;

import br.com.uniacademia.escolabellini.modelo.Ensino;
import br.com.uniacademia.escolabellini.repository.EnsinoRepository;

public class AtualizacaoEnsinoForm {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Ensino atualizar(Long id, EnsinoRepository ensinoRepo) {
		Ensino ensino = ensinoRepo.getOne(id);
		ensino.setNome(this.nome);
		return ensino;
	}
}
