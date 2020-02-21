package br.com.vilt.cookies.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vilt.cookies.atualizacao.form.AtualizaColaboradorCookieForm;
import br.com.vilt.cookies.atualizacao.form.AtualizaColaboradorForm;
import br.com.vilt.cookies.controller.dto.ColaboradorDto;
import br.com.vilt.cookies.controller.form.ColaboradorForm;
import br.com.vilt.cookies.enumm.Cookie;
import br.com.vilt.cookies.model.Colaborador;
import br.com.vilt.cookies.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository repository;

	
	@GetMapping("/cookies")
	@Cacheable(value = "listaColaboradoresCookies")
	public List<ColaboradorDto> list() {
		List<Colaborador> colaboradores = repository.findCookies();
		return ColaboradorDto.converter(colaboradores);
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity<ColaboradorDto> cadastrar(@RequestBody @Valid ColaboradorForm form,
			UriComponentsBuilder uriBuilder) {

		Colaborador colaborador = form.converter(repository);
		repository.save(colaborador);
		URI uri = uriBuilder.path("/colaborador/{id}").buildAndExpand(colaborador.getId()).toUri();

		System.out.println(uri);
		return ResponseEntity.created(uri).body(new ColaboradorDto(colaborador));

	}
	
	
	

	@PutMapping("/adiarCookie/{id}")
	@Transactional
	public ResponseEntity<ColaboradorDto> atualizarCookie(@PathVariable Long id,
			@RequestBody @Valid AtualizaColaboradorCookieForm form) {
		
		Optional<Colaborador> optional = repository.findById(id);

		if (optional.isPresent() && (optional.get().getStatus() == Cookie.AUSENTE.get()
				|| optional.get().getStatus() == Cookie.FERIAS.get())) {

			Colaborador colaborador = form.atualizar(id, repository);
			return ResponseEntity.ok(new ColaboradorDto(colaborador));

		}
		return ResponseEntity.notFound().build();

	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ColaboradorDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizaColaboradorForm form) {

		Optional<Colaborador> optional = repository.findById(id);

		if (optional.isPresent()) {

			Colaborador colaborador = form.atualizar(id, repository);
			return ResponseEntity.ok(new ColaboradorDto(colaborador));

		}
		return ResponseEntity.notFound().build();

	}
	
	

}
