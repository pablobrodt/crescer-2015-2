package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Servico;

@Repository
public class ServicoDao implements IBaseDao<Servico> {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Servico findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
