package br.com.uniacademia.escolabellini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uniacademia.escolabellini.modelo.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	List<Turma> findByEnsino_Nome(String nomeEnsino);
	
	Turma findByNome(String nomeTurma);
}
