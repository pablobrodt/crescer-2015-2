package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Material;

public class MaterialDAOTest extends AbstractTest {

    @Autowired
    private MaterialDao materialDAO;

    @Test
    public void deveBuscarMaterialPorId() throws Exception {
        Material material = materialDAO.findById(1L);
        Assert.assertNotNull(material);
    }
}
