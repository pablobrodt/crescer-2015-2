package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Material;

@Repository
public class MaterialDao extends AbstractDao {

	public Material findById(Long id) {
		return em.find(Material.class, id);
	}

	public List<Material> findAll() {
		return em.createQuery("FROM Material").getResultList();
	}
}
