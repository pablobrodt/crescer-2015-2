package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
        /*
         * Cliente cliente = new Cliente();
         * cliente.setIdCliente(1L);
         * cliente.setNmCliente("Joao");
         * ClienteDao clienteDao = new ClienteDao();
         * clienteDao.insert(cliente);
         */
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> lista = clienteDao.listAll();
        for (Cliente cliente : lista) {
            System.out.println(cliente.getNmCliente());
        }

    }
}
