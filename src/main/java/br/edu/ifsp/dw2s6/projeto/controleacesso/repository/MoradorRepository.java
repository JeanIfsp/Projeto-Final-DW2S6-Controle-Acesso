package br.edu.ifsp.dw2s6.projeto.controleacesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Morador;


@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long>{
	

}
