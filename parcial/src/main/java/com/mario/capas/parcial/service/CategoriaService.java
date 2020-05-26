package com.mario.capas.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mario.capas.parcial.domain.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public void insert(Categoria categoria) throws DataAccessException;
	
}
