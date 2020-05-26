package com.mario.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mario.capas.parcial.dao.LibroDAO;
import com.mario.capas.parcial.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDAO.findAll();
	}

	@Override
	public void insert(Libro libro) throws DataAccessException {
		libroDAO.insert(libro);
	}

}
