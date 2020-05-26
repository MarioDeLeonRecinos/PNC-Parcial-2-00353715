package com.mario.capas.parcial.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mario.capas.parcial.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@PersistenceContext(name = "capas")
	EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sBuffer.toString(), Categoria.class);
		List<Categoria> categorias = query.getResultList();
		return categorias;
	}

	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		entityManager.persist(categoria);
	}

}
