package com.ifrr.projetote.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ifrr.projetote.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {
	
	@Autowired
	EntityManager em;
	
	@Override
	@Transactional
	public Cozinha inserir(Cozinha obj) {
		return em.merge(obj);
	}
	
	@Override
	public Cozinha selecionar(Long codigo) {
		return em.find(Cozinha.class, codigo);
	}
	
	@Override
	@Transactional
	public void deletar(Long codigo) {
		em.remove(selecionar(codigo));
	}
	
	@Override
	public Boolean verificaSeExiste(Long codigo) {
		Cozinha cozinha = em.find(Cozinha.class, codigo);
		if(cozinha != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Cozinha> listar() {
		String jpql = "from Cozinha";
		TypedQuery<Cozinha> query = em.createQuery(jpql, Cozinha.class);
		return query.getResultList();
	}
}
