package com.ifrr.projetote.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifrr.projetote.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class CozinhaJPA {
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public Object inserir(Object obj) {
		return em.merge(obj);
	}
	
	public Object selecionar(Long codigo) {
		return em.find(Cozinha.class, codigo);
	}
	
	@Transactional
	public void deletar(Long codigo) {
		em.remove(selecionar(codigo));
	}
	
	public Boolean verificaSeExiste(Long codigo) {
		Cozinha cozinha = em.find(Cozinha.class, codigo);
		if(cozinha != null) {
			return true;
		}
		return false;
	}
	
	public List<Cozinha> listar() {
		String jpql = "from Cozinha";
		TypedQuery<Cozinha> query = em.createQuery(jpql, Cozinha.class);
		return query.getResultList();
	}
}
