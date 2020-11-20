package br.com.uniacademia.escolabellini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uniacademia.escolabellini.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
