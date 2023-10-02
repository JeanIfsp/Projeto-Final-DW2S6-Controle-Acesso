package br.edu.ifsp.dw2s6.projeto.controleacesso.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Visitas;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.VisitasRespository;


@Service
public class VisitasService {
	
	@Autowired
	private VisitasRespository visitasRepository;
	
	public Visitas update(Long id, Visitas visitas) {
		Visitas visitasSaved = findVisitasById(id);
		BeanUtils.copyProperties(visitas, visitasSaved, "id");
		return visitasRepository.save(visitasSaved);
	}

	
	
	public Visitas findVisitasById(Long id) {
		Visitas visitasSaved = visitasRepository.findById(id)
				.orElseThrow(
				(() -> new EmptyResultDataAccessException(1)));
		return visitasSaved;
	}

}
