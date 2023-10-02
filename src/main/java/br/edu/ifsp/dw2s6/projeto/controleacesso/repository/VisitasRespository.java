package br.edu.ifsp.dw2s6.projeto.controleacesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Visitas;

@Repository
public interface VisitasRespository  extends JpaRepository<Visitas, Long>{

}
