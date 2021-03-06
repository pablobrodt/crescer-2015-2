package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Cidade;

public class CidadeDaoTest extends AbstractTest {
	
	@Autowired
	private CidadeDao cidadeDao;
	
    @Test
    public void deveBuscarCidadePorId() throws Exception {
        Cidade cidade = cidadeDao.findById(1L);
        Assert.assertNotNull(cidade);
    }
}
