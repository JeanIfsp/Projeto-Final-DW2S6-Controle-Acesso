package br.edu.ifsp.dw2s6.projeto.controleacesso.resource;

import java.util.List;
import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Funcionario;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.FuncionarioRepository;
import br.edu.ifsp.dw2s6.projeto.controleacesso.services.FuncionarioService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	
	public List<Funcionario> list(){
		return funcionarioRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario create(@Valid @RequestBody Funcionario funcionario, 
			HttpServletResponse response) {
		return funcionarioRepository.save(funcionario);
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Long id,
			@Valid @RequestBody Funcionario funcionario){
		Funcionario funcionarioSaved = funcionarioService.update(id, funcionario);
		return ResponseEntity.ok(funcionarioSaved);
	}
	
	@PutMapping("/{id}/active")
	
	public void updatePropriedadeAtivo(
			@PathVariable Long id,
			@RequestBody Boolean active){
		funcionarioService.updatePropriedadeAtivo(id, active);
	}
	
}
