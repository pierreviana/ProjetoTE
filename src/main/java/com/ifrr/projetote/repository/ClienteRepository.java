package com.ifrr.projetote.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifrr.projetote.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class ClienteRepository {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Cliente inserir(Cliente cliente) {
		return entityManager.merge(cliente);
	}

	public Cliente selecionar(Long codigo) {
		return entityManager.find(Cliente.class, codigo);
	}

	@Transactional
	public Cliente alterar(Cliente cliente) {
		return entityManager.merge(cliente);
	}

	public Boolean verificaSeExiste(Long codigo) {
		Cliente cliente = entityManager.find(Cliente.class, codigo);
		if (cliente != null) {
			return true;
		}
		return false;
	}

	@Transactional
	public void excluir(Long codigo) {
		entityManager.remove(selecionar(codigo));
	}

	public List<Cliente> listar() {
		String jpql = "from Cliente";
		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
		return query.getResultList();
	}

}
