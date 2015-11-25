package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDao extends AbstractDao {

	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> findBySituacao(SituacaoPedido situacao){
		return em.createQuery("FROM Pedido p WHERE p.situacao = :situacao", Pedido.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}
}
