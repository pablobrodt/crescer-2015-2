import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf( "Gimli" );
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        Dwarf gimli = new Dwarf( "Gimli" );
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha11VezesEVidaÉ0() {
        Dwarf gimli = new Dwarf( "Gimli" );
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha7VezesEVidaÉ40() {
        Dwarf gimli = new Dwarf( "Gimli" );
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf gloin = new Dwarf( "Gloin" );
        assertEquals(Status.VIVO, gloin.getStatus());
    }

    
    @Test
    public void quandoAVidaDoDwarfÉ0EleMorre(){
        Dwarf gimli = new Dwarf ( "Gimli" );
        
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        
        assertEquals( Status.MORTO, gimli.getStatus() );
        
    }
    
    @Test
    public void dwarfCriadoComNomeNaoNulo() {
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals("Gimli", gimli.getNome());
    }

    @Test
    public void dwarfCriadoComNomeNulo() {
        Dwarf gimli = new Dwarf(null);
        assertNull(gimli.getNome());
    }

    @Test
    public void dwarfCriadoNasceCom0DeExperiencia() {
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(0, gimli.getExperiencia());
    }
}
