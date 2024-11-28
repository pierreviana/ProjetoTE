package com.ifrr.projetote.repository;

import java.util.List;

import com.ifrr.projetote.model.Cozinha;

public interface CozinhaRepository {

	public Cozinha inserir(Cozinha obj);

	public Cozinha selecionar(Long codigo);

	public void deletar(Long codigo);

	public Boolean verificaSeExiste(Long codigo);

	public List<Cozinha> listar();

}