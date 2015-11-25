package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;

@Repository
public class CidadeDao extends AbstractDao {
	
	public Cidade findById(Long id) {
		return em.find(Cidade.class, id);
	}

	public List<Cidade> findAll() {
		return em.createQuery("FROM Cidade", Cidade.class).getResultList();
	}
}
