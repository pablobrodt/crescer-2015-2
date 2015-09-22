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
    public void snagaNasceComUmArco(){
        Snaga orc = new Snaga();
        Item itemEsperado = new Item(1, "Arco");
        Item itemDoOrc = orc.getInventario().getItens().get(orc.getInventario().getItens().indexOf(new Item(1, "Arco")));
        assertEquals(itemEsperado, itemDoOrc);
    }
    
    @Test
    public void snagaNasceCom5Flechas(){
        Snaga orc = new Snaga();
        Item itemEsperado = new Item(5, "Flecha");
        Item itemDoOrc = orc.getInventario().getItens().get(orc.getInventario().getItens().indexOf(new Item(5, "Flecha")));
        assertEquals(itemEsperado, itemDoOrc);
    }
}
