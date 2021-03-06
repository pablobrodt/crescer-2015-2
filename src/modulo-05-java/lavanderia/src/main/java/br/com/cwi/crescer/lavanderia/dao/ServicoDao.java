package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.domain.Servico;

@Repository
public class ServicoDao extends AbstractDao {
	
	public Servico findById(Long id) {
		return em.find(Servico.class, id);
	}

	public List<Servico> findAll() {
		return em.createQuery("FROM Servico").getResultList();
	}
}
