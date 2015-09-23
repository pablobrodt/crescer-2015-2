import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest
{
    @Test
    public void snagaNasceCom70DeVida(){
        Snaga orc = new Snaga();
        assertEquals(70, orc.getVida());
    }

    @Test
    public void snagaNasceCom1ArcoE5Flechas(){
        Snaga orc = new Snaga();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Arco"));
        esperado.adicionarItem(new Item(5, "Flecha"));
        
        assertEquals(esperado, orc.getInventario());
    }
    
    @Test
    public void snagaAtacaUrukHai(){
        Snaga orc = new Snaga();
        UrukHai uruk = new UrukHai();
        
        orc.atacar(uruk);
        
        assertEquals(144, uruk.getVida());
    }
    
    @Test
    public void snagaAtacaSnaga(){
        Snaga orc = new Snaga();
        Snaga orcAlvo = new Snaga();
        
        orc.atacar(orcAlvo);
        
        assertEquals(60, orcAlvo.getVida());
    }
}
