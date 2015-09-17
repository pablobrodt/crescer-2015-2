import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void dwarfSofreDanoDeFlechada(){
        Dwarf gimli = new Dwarf();
        int vida = gimli.getVida();
        gimli.receberFlechada();
        assertTrue(vida > gimli.getVida());
    }
}
