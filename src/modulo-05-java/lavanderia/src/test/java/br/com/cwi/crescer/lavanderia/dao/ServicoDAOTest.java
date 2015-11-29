package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Servico;

public class ServicoDAOTest extends AbstractTest {

    @Autowired
    private ServicoDao servicoDAO;

    @Test
    public void deveBuscarServicoPorId() throws Exception {
        Servico servico = servicoDAO.findById(1L);
        Assert.assertNotNull(servico);
    }
}
