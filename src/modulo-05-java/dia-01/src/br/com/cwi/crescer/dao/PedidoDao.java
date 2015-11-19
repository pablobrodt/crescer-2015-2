package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;
import br.com.cwi.crescer.model.Interfaces.BaseDao;

public class PedidoDao implements BaseDao<Pedido> {

    @Override
    public void insert(Pedido pedido) throws SQLException {
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO Pedido ");
            query.append("(idPedido, idCliente, dsPedido) ");
            query.append("VALUES (pedido_seq.nextval, ?, ?)");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void update(Pedido pedido) throws SQLException {
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("UPDATE Pedido ");
            query.append("SET ");
            query.append("idCliente = ?, ");
            query.append("dsPedido = ? ");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void delete(Long idPedido) throws SQLException {
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM Pedido ");
            query.append("WHERE idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setLong(1, idPedido);

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Pedido load(Long idPedido) throws SQLException {

        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("SELECT idPedido, idCliente, dsPedido FROM Pedido ");
            query.append("WHERE idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            statement.setLong(1, idPedido);

            ResultSet resultSet = statement.executeQuery();

            ClienteDao clienteDao = new ClienteDao();

            if (resultSet.next()) {
                Long resultIdCliente = resultSet.getLong(2);

                Cliente cliente = clienteDao.load(resultIdCliente);

                return buildPedido(cliente, resultSet);
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Pedido> find(Pedido pedido) throws Exception {
        Long idPedido = pedido.getIdPedido();
        Long idCliente = pedido.getIdCliente();
        String dsPedido = pedido.getDsPedido();

        if (idCliente == null && idPedido == null && dsPedido == null) {
            throw new Exception("Pedido com campos nulos!");
        }

        List<Pedido> resultado = new ArrayList<Pedido>();
        ArrayList<String> filtros = new ArrayList<>();
        ArrayList<Object> campos = new ArrayList<>();

        if (idPedido != null) {
            try {
                resultado.add(this.load(idPedido));
                return resultado;
            } catch (SQLException e) {
                throw e;
            }
        }

        if (idCliente != null) {
            filtros.add("idCliente = ? ");
            campos.add(pedido.getIdCliente());
        }

        if (dsPedido != null) {
            filtros.add("dsPedido = ? ");
            campos.add(dsPedido);
        }

        StringBuilder query = new StringBuilder();
        query.append("SELECT idPedido, idCliente, dsPedido ");
        query.append("FROM Pedido ");
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
                    statement.setObject(i, campos.get(i - 1));
                }
            }

            ResultSet resultSet = statement.executeQuery();

            ClienteDao clienteDao = new ClienteDao();

            while (resultSet.next()) {
                Long resultIdCliente = resultSet.getLong(2);

                Cliente cliente = clienteDao.load(resultIdCliente);

                resultado.add(buildPedido(cliente, resultSet));
            }

        } catch (SQLException e) {
            throw e;
        }

        return resultado;
    }

    @Override
    public List<Pedido> findAll() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        try (Connection conexao = getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append("SELECT idPedido, idCliente, dsPedido ");
            query.append("FROM Pedido");

            PreparedStatement statement = conexao.prepareStatement(query.toString());

            ResultSet resultSet = statement.executeQuery();

            ClienteDao clienteDao = new ClienteDao();

            while (resultSet.next()) {
                Long resultIdCliente = resultSet.getLong(2);

                Cliente cliente = clienteDao.load(resultIdCliente);

                pedidos.add(buildPedido(cliente, resultSet));
            }

        } catch (SQLException e) {
            throw e;
        }

        return pedidos;
    }

    // Util
    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection();
    }

    private Pedido buildPedido(Cliente cliente, ResultSet resultSet) throws SQLException {
        Pedido pedido = new Pedido(cliente);
        pedido.setIdPedido(resultSet.getLong(1));
        pedido.setDsPedido(resultSet.getString(3));

        return pedido;
    }
}
