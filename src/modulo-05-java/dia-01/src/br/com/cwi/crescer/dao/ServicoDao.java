package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void insert(Servico servico) throws SQLException {
        try (Connection conexao = ConnectionFactory.getConnection()) {
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

    public List<Servico> findAll() throws SQLException {

        List<Servico> lista = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("SELECT idServico, dsServico FROM Servico");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                Servico servico = new Servico();
                servico.setIdServico(resultado.getLong(1));
                servico.setDsServico(resultado.getString(2));

                lista.add(servico);
            }
        } catch (SQLException e) {
            throw e;
        }

        return lista;
    }
}
