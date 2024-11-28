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

import com.ifrr.projetote.model.Cliente;
import com.ifrr.projetote.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable("id") Long id) {
		try {
			if (clienteRepository.verificaSeExiste(id)) {
				clienteRepository.excluir(id);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteRepository.inserir(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		if (clienteRepository.verificaSeExiste(id)) {
			cliente.setCodigo(id);
			Cliente clienteAlterado = clienteRepository.alterar(cliente);
			return ResponseEntity.ok(clienteAlterado);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public Object listar() {
		return clienteRepository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> selecionar(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.selecionar(id);

		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}

}
