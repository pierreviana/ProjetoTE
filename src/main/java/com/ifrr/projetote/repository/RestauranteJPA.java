package com.ifrr.projetote.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RestauranteJPA {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Object inserir(Object obj) {
		return em.merge(obj);
	}
}
