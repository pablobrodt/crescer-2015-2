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
    public void urukHaiNasceCom1EspadaE1EscudoUH(){
        UrukHai orc = new UrukHai();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Espada"));
        esperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        
        assertEquals(esperado, orc.getInventario());
    }
}
