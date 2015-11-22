package br.com.cwi.crescer.lavanderia.dao;

public interface IBaseDao<T> {
	
	T findById(Long id);
	
}
