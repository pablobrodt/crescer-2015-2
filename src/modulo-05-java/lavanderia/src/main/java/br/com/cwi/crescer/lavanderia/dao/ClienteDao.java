package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao extends AbstractDao implements IBaseDao<Cliente>{
	
	@Override
	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> findBySituacao(SituacaoCliente situacao){
		return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}
}
