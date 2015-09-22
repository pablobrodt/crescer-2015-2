import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest
{
    @Test
    public void urukHaiNasceCom150DeVida(){
        UrukHai orc = new UrukHai();
        assertEquals(150, orc.getVida());
    }
    
    @Test
    public void urukHaiNasceComUmEscudo(){
        UrukHai orc = new UrukHai();
        Item itemEsperado = new Item(1, "Escudo Uruk-Hai");
        Item itemDoOrc = orc.getInventario().getItens().get(orc.getInventario().getItens().indexOf(new Item(1, "Escudo Uruk-Hai")));
        assertEquals(itemEsperado, itemDoOrc);
    }
    
    @Test
    public void urukHaiNasceComUmaEspada(){
        UrukHai orc = new UrukHai();
        Item itemEsperado = new Item(1, "Espada");
        Item itemDoOrc = orc.getInventario().getItens().get(orc.getInventario().getItens().indexOf(new Item(1, "Espada")));
        assertEquals(itemEsperado, itemDoOrc);
    }
}
