package br.com.uniacademia.escolabellini.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_ensino")
	private Ensino ensino;			
	
	private int ano;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> listaAlunos;

	public Turma() {
	}

	public Turma(String nome, Ensino ensino, int ano, List<Aluno> listaAlunos) {
		super();
		this.nome = nome;
		this.ensino = ensino;
		this.ano = ano;
		this.listaAlunos = listaAlunos;
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

	public Ensino getEnsino() {
		return ensino;
	}

	public void setEnsino(Ensino ensino) {
		this.ensino = ensino;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
}
