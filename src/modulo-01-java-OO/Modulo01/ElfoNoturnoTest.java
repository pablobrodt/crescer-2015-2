import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoAtira1FlechaEFicaCom95DeVida(){
        ElfoNoturno elfo = new ElfoNoturno("Danoite");
        elfo.atirarFlecha(new Dwarf());
        assertEquals(95, elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoAtira2FlechasEFicaCom90DeVida(){
        ElfoNoturno elfo = new ElfoNoturno("Danoite");
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(90, elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoAtira3FlechasEFicaCom85DeVida(){
        ElfoNoturno elfo = new ElfoNoturno("Danoite");
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(85, elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoAtira4FlechasEFicaCom80DeVida(){
        ElfoNoturno elfo = new ElfoNoturno("Danoite");
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(80, elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoMorreAoAtirarMuitasFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("Danoite");
        while(elfo.getStatus() != Status.MORTO){
            elfo.atirarFlecha(new Dwarf());
        }
        assertEquals(Status.MORTO, elfo.getStatus());
    }

}
