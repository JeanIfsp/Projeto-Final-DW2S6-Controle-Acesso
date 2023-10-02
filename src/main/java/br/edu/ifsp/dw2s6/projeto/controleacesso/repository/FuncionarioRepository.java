package br.edu.ifsp.dw2s6.projeto.controleacesso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	public Optional<Funcionario> findByEmail(String email);

}

