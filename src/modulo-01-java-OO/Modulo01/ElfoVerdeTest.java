import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeGanha2DeExperiencia(){
        ElfoVerde ev = new ElfoVerde("Legolas Verde");
        int experienciaEsperada = 2;
        ev.atirarFlecha(new Dwarf());
        assertEquals(experienciaEsperada, ev.getExperiencia());
        
    }
    
    @Test
    public void elfoVerdeNaoGanhaEspadaComum(){
        ElfoVerde ev = new ElfoVerde("Legolas Verde");
        int itensEsperados = 0;
        ev.adicionarItem(new Item(1, "Espada Comum"));
        int itensObtidos = ev.getInventario().getItens().size();
        
        assertEquals(itensEsperados, itensObtidos);
        
    }
    
    @Test
    public void elfoVerdeGanhaEspadaDeAçoValiriano(){
        ElfoVerde ev = new ElfoVerde("Legolas Verde");
        int itensEsperados = 1;
        ev.adicionarItem(new Item(1, "Espada de aço valiriano"));
        int itensObtidos = ev.getInventario().getItens().size();
        
        assertEquals(itensEsperados, itensObtidos);
    }
    
    @Test
    public void elfoVerdeGanhaArcoEFlechaDeVidro(){
        ElfoVerde ev = new ElfoVerde("Legolas Verde");
        int itensEsperados = 1;
        ev.adicionarItem(new Item(1, "Arco e Flecha de Vidro"));
        int itensObtidos = ev.getInventario().getItens().size();
        
        assertEquals(itensEsperados, itensObtidos);
        
    }
}
