import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{   
    private int vidaDoDwarf;
    private Dwarf gimli;
    
    public DwarfTest(){
        gimli = new Dwarf();
        this.vidaDoDwarf = gimli.getVida();
        gimli.receberFlechada();
    }
    
    @Test
    public void dwarfNasceCom110DeVida() {
        assertEquals(110, this.vidaDoDwarf);
    }
    
    @Test
    public void dwarfSofreDanoDeFlechada(){
        assertTrue(this.vidaDoDwarf > gimli.getVida());
    }
    
    @Test
    public void dwarfNaoSofreDanoDeFlechada(){
        assertFalse(this.vidaDoDwarf > gimli.getVida());
    }
    
}
