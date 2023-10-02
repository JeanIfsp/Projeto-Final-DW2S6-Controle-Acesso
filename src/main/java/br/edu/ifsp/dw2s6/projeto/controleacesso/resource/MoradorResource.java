package br.edu.ifsp.dw2s6.projeto.controleacesso.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Morador;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.MoradorRepository;
import br.edu.ifsp.dw2s6.projeto.controleacesso.services.MoradorService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/moradores")
public class MoradorResource {
	
	@Autowired
	private MoradorRepository moradorRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	@GetMapping
	
	public List<Morador> list(){
		return moradorRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Morador create(@Valid @RequestBody Morador morador, 
			HttpServletResponse response) {
		return moradorRepository.save(morador);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Morador> findById(@PathVariable Long id){
		Optional<Morador> morador = moradorRepository.findById(id);
		if(morador.isPresent()) {
			return ResponseEntity.ok(morador.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		moradorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Morador> update(@PathVariable Long id,
			@Valid @RequestBody Morador morador){
		Morador moradorSaved = moradorService.update(id, morador);
		return ResponseEntity.ok(moradorSaved);
	}
	
	@PutMapping("/{id}/active")
	public void updatePropriedadeAtivo(
			@PathVariable Long id,
			@RequestBody Boolean active){
		moradorService.updatePropriedadeAtivo(id, active);
	}

}
