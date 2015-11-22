package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDao implements IBaseDao<Produto>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}
	
}
