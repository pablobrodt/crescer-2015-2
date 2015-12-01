package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

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
	
	@Transactional
	public Item save(Item entity) {
		if(entity.getIdItem() == null){
			em.persist(entity);
			return entity;
		}else{
			return em.merge(entity);
		}
	}
}
