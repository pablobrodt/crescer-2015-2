

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    
    @Test
    public void itemTemDescricaoCurta(){
        Item pocao = new Item("Poção", 1);
        String descricaoEsperada = "Poção";
        assertEquals(descricaoEsperada, pocao.getDescricao());
    }
    
    @Test
    public void itemTemDescricaoNull(){
        Item pocao = new Item(null, 1);
        String descricaoEsperada = null;
        assertEquals(descricaoEsperada, pocao.getDescricao());
    }
    
    @Test
    public void itemTemDescricaoNemLonga(){
        Item pocao = new Item("Este item tem uma descriçao bem grande para podermos testa-lo.", 1);
        String descricaoEsperada = "Este item tem uma descriçao bem grande para podermos testa-lo.";
        assertEquals(descricaoEsperada, pocao.getDescricao());
    }
    
    @Test
    public void itemTemQuantidade10(){
        Item pocao = new Item("Poção", 10);
        int quantidadeEsperada = 10;
        assertEquals(quantidadeEsperada, pocao.getQuantidade());
    }
    
    @Test
    public void itemTemquantidadeNegativa(){
        Item pocao = new Item("Poção", -10);
        int quantidadeEsperada = -10;
        assertEquals(quantidadeEsperada, pocao.getQuantidade());
    }
    @Test
    public void itemTemQuantidadeOver9000(){
        Item pocao = new Item("Poção", 9001);
        int quantidadeEsperada = 9001;
        assertEquals(quantidadeEsperada, pocao.getQuantidade());
    }
      
}
