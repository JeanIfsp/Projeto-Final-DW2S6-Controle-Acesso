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

import br.edu.ifsp.dw2s6.projeto.controleacesso.model.Visitas;
import br.edu.ifsp.dw2s6.projeto.controleacesso.repository.VisitasRespository;
import br.edu.ifsp.dw2s6.projeto.controleacesso.services.VisitasService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitas")
public class VisitasResource {
	
	@Autowired
	private VisitasRespository visitasRepository;
	
	@Autowired
	private VisitasService visitasService;
	
	@GetMapping
	
	public List<Visitas> list(){
		return visitasRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Visitas create(@Valid @RequestBody Visitas visitas, 
			HttpServletResponse response) {
		return visitasRepository.save(visitas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Visitas> findById(@PathVariable Long id){
		Optional<Visitas> visita = visitasRepository.findById(id);
		if(visita.isPresent()) {
			return ResponseEntity.ok(visita.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		visitasRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Visitas> update(@PathVariable Long id,
			@Valid @RequestBody Visitas visitas){
		Visitas visitasSaved = visitasService.update(id, visitas);
		return ResponseEntity.ok(visitasSaved);
	}
	
	
}
