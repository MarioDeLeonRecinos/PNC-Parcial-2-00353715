package com.mario.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mario.capas.parcial.dao.CategoriaDAO;
import com.mario.capas.parcial.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}

	@Override
	public void insert(Categoria categoria) throws DataAccessException {
		categoriaDAO.insert(categoria);
	}
	
}
