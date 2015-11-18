package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("INSERT INTO Cliente (idCliente, nmCliente, nrCpf) VALUES (?, ?, ?)");

            statement.setLong(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNmCliente());
            statement.setString(3, cliente.getNrCpf());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("UPDATE Cliente SET nmCliente = ?, nrCpf = ? ");
            query.append("WHERE idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("SELECT idCliente, nmCliente, nrCpf FROM Cliente");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultado.getLong(1));
                cliente.setNmCliente(resultado.getString(2));
                cliente.setNrCpf(resultado.getString(3));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        }

        return clientes;
    }
}
