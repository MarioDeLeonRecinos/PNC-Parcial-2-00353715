package com.mario.capas.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mario.capas.parcial.domain.Libro;

public interface LibroDAO {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void insert(Libro libro) throws DataAccessException;
	
}
