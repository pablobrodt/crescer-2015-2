package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoDAOTest extends AbstractTest {

    @Autowired
    private ProdutoDao produtoDAO;

    @Test
    public void deveBuscarProdutoPorId() throws Exception {
        Produto produto = produtoDAO.findById(1L);
        Assert.assertNotNull(produto);
    }
    
    @Test
    public void buscaPorIdDeveRetornarProdutoComServico(){
    	Produto produto = produtoDAO.findById(1L);
    	Assert.assertNotNull(produto.getServico());
    }
    
    @Test
    public void buscaPorIdDeveRetornarProcutoComMaterial(){
    	Produto produto = produtoDAO.findById(1L);
    	Assert.assertNotNull(produto.getMaterial());
    }
}
