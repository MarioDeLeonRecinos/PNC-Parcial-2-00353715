package com.mario.capas.parcial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mario.capas.parcial.domain.Categoria;
import com.mario.capas.parcial.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@PersistenceContext(name = "capas")
	EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sBuffer.toString(), Libro.class);
		List<Libro> libros = query.getResultList();
		return libros;
	}

	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
	}

}
