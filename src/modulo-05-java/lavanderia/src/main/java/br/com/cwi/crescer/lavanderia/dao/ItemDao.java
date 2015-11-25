package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Repository
public class ItemDao extends AbstractDao {

	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> findBySituacao(SituacaoItem situacao){
		return em.createQuery("FROM Item i WHERE i.situacao = :situacao", Item.class)
				.setParameter("situacao", situacao)
				.getResultList();				
	}
}
