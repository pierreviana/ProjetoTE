package com.ifrr.projetote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.repository.CozinhaRepository;
import com.ifrr.projetote.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaJPA;
	
	@Autowired
	private CozinhaService cozinhaService;

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		try {
			if (cozinhaJPA.verificaSeExiste(id)) {
				cozinhaJPA.deletar(id);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Object inserir(@RequestBody Cozinha obj) {
		return cozinhaService.inserir(obj);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Cozinha cozinha) {
		if (cozinhaJPA.verificaSeExiste(id)) {
			cozinha.setCodigo(id);
			Cozinha cozinhaAlterada = (Cozinha) cozinhaService.inserir(cozinha);
			return ResponseEntity.ok(cozinhaAlterada);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public Object listar() {
		return cozinhaJPA.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> selecionar(@PathVariable("id") Long id) {
		Cozinha cozinha = (Cozinha) cozinhaJPA.selecionar(id);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}

		return ResponseEntity.notFound().build();
	}

}
