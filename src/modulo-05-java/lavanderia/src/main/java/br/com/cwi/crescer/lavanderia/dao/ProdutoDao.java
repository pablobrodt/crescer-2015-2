package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;

@Repository
public class ProdutoDao extends AbstractDao {

	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> findByServico(Long idServico) {
		return em.createQuery("FROM Produto WHERE idServico = :idServico")
				.setParameter("idServico", idServico)
				.getResultList();
	}

	public Produto findByServicoMaterial(Long idServico, Long idMaterial) {
		return (Produto) em.createQuery("FROM Produto WHERE idServico = :idServico AND idMaterial = :idMaterial")
				.setParameter("idServico", idServico)
				.setParameter("idMaterial", idMaterial)
				.getSingleResult();
	}
}
