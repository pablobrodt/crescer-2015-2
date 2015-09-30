

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
    @Test
    public void orcAtacaElfoComEspada(){
        Orc orc = new Orc();
        Elfo elfo = new Elfo("Legolas");
        int vidaEsperada = 88;
        orc.getInventario().adicionarItem(new Item(1, "Espada"));
        
        orc.atacar(elfo);
        
        assertEquals(vidaEsperada, elfo.getVida(), 0.0);
    }
    
    @Test
    public void orcAtacaElfoComArco(){
        Orc orc = new Orc();
        Elfo elfo = new Elfo("Legolas");
        int vidaEsperada = 92;
        orc.getInventario().adicionarItem(new Item(1, "Arco"));
        orc.getInventario().adicionarItem(new Item(2, "Flecha"));
        
        orc.atacar(elfo);
        
        assertEquals(vidaEsperada, elfo.getVida(), 0.0);
    }
    
    @Test
    public void orcAtacaAnaoComEspada(){
        Orc orc = new Orc();
        Dwarf anao = new Dwarf();
        int vidaEsperada = 98;
        orc.getInventario().adicionarItem(new Item(1, "Espada"));
        
        orc.atacar(anao);
        
        assertEquals(vidaEsperada, anao.getVida(), 0.0);
    }
        
    @Test
    public void orcAtacaAnaoComArco(){
        Orc orc = new Orc();
        Dwarf anao = new Dwarf();
        int vidaEsperada = 102;
        orc.getInventario().adicionarItem(new Item(1, "Arco"));
        orc.getInventario().adicionarItem(new Item(2, "Flecha"));
        
        orc.atacar(anao);
        
        assertEquals(vidaEsperada, anao.getVida(), 0.0);
    }
        
    @Test
    public void orcPerdeFlechas(){
        Orc orc = new Orc();
        Dwarf anao = new Dwarf();
        Item flecha = new Item(3, "Flecha");
        orc.getInventario().adicionarItem(new Item(1, "Arco"));
        orc.getInventario().adicionarItem(flecha);
        
        orc.atacar(anao);
        orc.atacar(anao);
        
        assertEquals(1, flecha.getQuantidade());
    }



    
}
