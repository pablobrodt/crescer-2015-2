package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDao extends AbstractDao {

	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> findAll() {
		return em.createQuery("FROM Pedido")
				.getResultList();
	}
	
	public List<Pedido> findBySituacao(SituacaoPedido situacao){
		return em.createQuery("FROM Pedido p WHERE p.situacao = :situacao", Pedido.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}

    @Transactional
    public Pedido save(Pedido pedido) {

        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }

        return em.merge(pedido);
    }

	public void process(Pedido entity) {
		
	}
}
