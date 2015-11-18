package br.com.cwi.crescer.model.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {

    void insert(T obj) throws SQLException;

    void update(T obj) throws SQLException;

    void delete(Long id) throws SQLException;

    T load(Long id) throws SQLException;

    List<T> findAll() throws SQLException;

    List<T> find(T obj) throws Exception;
}
