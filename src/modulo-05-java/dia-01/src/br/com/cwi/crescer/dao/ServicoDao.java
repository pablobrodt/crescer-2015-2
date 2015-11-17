package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO Servico (idServico, dsServico) ");
            query.append("VALUES(?, ?)");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setLong(1, servico.getIdServico());
            statement.setString(2, servico.getDsServico());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }
}
