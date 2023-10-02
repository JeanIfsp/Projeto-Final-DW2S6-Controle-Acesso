package br.edu.ifsp.dw2s6.projeto.controleacesso.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Morador;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.MoradorRepository;

@Service
public class MoradorService {
	
	@Autowired
	private  MoradorRepository moradorRepository;

	public Morador update(Long id, Morador morador) {
		Morador moradorSaved = findMoradorById(id);
		BeanUtils.copyProperties(morador, moradorSaved, "id");
		return moradorRepository.save(moradorSaved);
	}

	public void updatePropriedadeAtivo(Long id, Boolean ativo) {
		Morador moradorSaved = findMoradorById(id);
		moradorSaved.setAtivo(ativo);
		moradorRepository.save(moradorSaved);
	}
	
	public Morador findMoradorById(Long id) {
		Morador moradorSaved = moradorRepository.findById(id)
				.orElseThrow(
				(() -> new EmptyResultDataAccessException(1)));
		return moradorSaved;
	}

}
