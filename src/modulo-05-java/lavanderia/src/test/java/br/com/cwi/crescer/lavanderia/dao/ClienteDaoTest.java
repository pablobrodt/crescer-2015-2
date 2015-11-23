package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

public class ClienteDaoTest extends AbstractInfrastructureTest{

    @Autowired
    private ClienteDao clienteDAO;

    @Test
    public void deveBuscarClientePorId() throws Exception {
        Cliente cliente = clienteDAO.findById(1L);
        Assert.assertNotNull(cliente);
    }
    
    @Test
    public void buscaPorIdDeveRetornarClienteComCidade() throws Exception {
        Cliente cliente = clienteDAO.findById(1L);
        Assert.assertNotNull(cliente.getCidade());
    }
    
    @Test
    public void buscaPorIdDeveRetornarClienteComPedidos(){
    	Cliente cliente = clienteDAO.findById(1L);
    	Assert.assertNotNull(cliente.getPedidos());
    }

    @Test
    public void deveBuscarClientesAtivos() throws Exception {
        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
        Assert.assertNotNull(clientes);
        Assert.assertFalse(clientes.isEmpty());

        for (Cliente cliente : clientes) {
            Assert.assertEquals(SituacaoCliente.ATIVO, cliente.getSituacao());
        }
    }
	
}
