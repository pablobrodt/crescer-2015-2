package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao extends AbstractDao{

	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> findBySituacao(SituacaoCliente situacao){
		return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}
	
    @Transactional
    public Cliente save(Cliente cliente) {

        if (cliente.getIdCliente() == null) {
            em.persist(cliente);
            return cliente;
        }

        return em.merge(cliente);
    }

    @Transactional
	public void delete(Long id) {
		this.em.remove(em.getReference(Cliente.class, id));
	}
}
