package br.edu.ifsp.dw2s6.projeto.controleacesso.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Funcionario;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario update(Long id, Funcionario funcionario) {
		Funcionario funcionarioSaved = findFuncionarioById(id);
		BeanUtils.copyProperties(funcionario, funcionarioSaved, "id");
		return funcionarioRepository.save(funcionarioSaved);
	}

	public void updatePropriedadeAtivo(Long id, Boolean ativo) {
		Funcionario funcionarioSaved = findFuncionarioById(id);
		funcionarioSaved.setAtivo(ativo);
		funcionarioRepository.save(funcionarioSaved);
	}
	
	public Funcionario findFuncionarioById(Long id) {
		Funcionario funcionarioSaved = funcionarioRepository.findById(id)
				.orElseThrow(
				(() -> new EmptyResultDataAccessException(1)));
		return funcionarioSaved;
	}

}
