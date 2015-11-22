package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;

@Repository
public class CidadeDao implements IBaseDao<Cidade>{
	
	@PersistenceContext
	private EntityManager em;

	public Cidade findById(Long id) {
		return em.find(Cidade.class, id);
	}

}
