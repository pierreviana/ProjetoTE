package com.ifrr.projetote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public Cozinha inserir(Cozinha cozinha) {
		return cozinhaRepository.inserir(cozinha);
	}
	
	public void excluir(Long codigo) {
		cozinhaRepository.deletar(codigo);
	}
}
