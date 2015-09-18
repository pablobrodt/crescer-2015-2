

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    
    @Test
    public void itemTemDescricao(){
        Item pocao = new Item("Recupera sua vida.", 1);
        String descricaoEsperada = "Recupera sua vida.";
        assertEquals(descricaoEsperada, pocao.getDescricao());
    }
    
    @Test
    public void itemTemQuantidade10(){
        Item pocao = new Item("Recupera sua vida.", 10);
        int quantidadeEsperada = 10;
        assertEquals(quantidadeEsperada, pocao.getQuantidade());
    }
      
}
