package br.com.uniacademia.escolabellini.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.uniacademia.escolabellini.modelo.Ensino;

public class EnsinoDto {
	private Long id;
	
	private String nome;
	
	public EnsinoDto() {
	}

	public EnsinoDto(Ensino ensino) {
		this.id = ensino.getId();
		this.nome = ensino.getNome();
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
	
	public static List<EnsinoDto> converter(List<Ensino> listaEnsinos){
		return listaEnsinos.stream().map(EnsinoDto::new).collect(Collectors.toList());
	}
	
}
