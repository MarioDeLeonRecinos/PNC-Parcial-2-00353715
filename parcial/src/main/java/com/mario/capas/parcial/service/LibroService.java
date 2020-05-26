package com.mario.capas.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mario.capas.parcial.domain.Libro;

public interface LibroService {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void insert(Libro libro) throws DataAccessException;
	
}
