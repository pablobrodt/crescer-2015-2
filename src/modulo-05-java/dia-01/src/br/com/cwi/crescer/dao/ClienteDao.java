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
    public List<Cliente> find(Cliente cliente) throws Exception {
        Long idCliente = cliente.getIdCliente();
        String nmCliente = cliente.getNmCliente();
        String nrCpf = cliente.getNrCpf();

        if (idCliente == null && nmCliente == null && nrCpf == null) {
            throw new Exception("Cliente com campos nulos!");
        }

        List<Cliente> resultado = new ArrayList<Cliente>();
        ArrayList<String> filtros = new ArrayList<>();
        ArrayList<String> campos = new ArrayList<>();

        if (idCliente != null) {
            try {
                resultado.add(this.load(idCliente));
                return resultado;
            } catch (SQLException e) {
                throw e;
            }
        }


        if(nmCliente != null){
            filtros.add("nmCliente = ? ");
            campos.add(nmCliente);
        }
        if(nrCpf != null){
            filtros.add("nrCpf = ? ");
            campos.add(nrCpf);
        }

        StringBuilder query = new StringBuilder();
        query.append("SELECT idCliente, nmCliente, nrCpf ");
        query.append("FROM Cliente ");
        query.append("WHERE ");

        try (Connection conexao = getConnection()) {

            if (!filtros.isEmpty()) {
                for (String filtro : filtros) {
                    query.append(filtro);
                    if (filtros.size() > 1 && filtros.indexOf(filtro) != filtros.size() - 1) {
                        query.append("AND ");
                    }
                }
            }

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            if (!campos.isEmpty()) {
                for (int i = 1; i <= campos.size(); i++) {
                    statement.setString(i, campos.get(i - 1));
                }
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(resultSet.getLong(1));
                c.setNmCliente(resultSet.getString(2));
                c.setNrCpf(resultSet.getString(3));

                resultado.add(c);
            }

        } catch (SQLException e) {
            throw e;
        }

        return resultado;
    }

    public void delete(Long idCliente) throws SQLException {
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM Cliente WHERE idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idCliente);

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
