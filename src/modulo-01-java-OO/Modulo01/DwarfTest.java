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
    public void dwarfRecebe12FlechadasEFicaCom0DeVida(){
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
        gimli.receberFlechada();
        
        assertEquals(0, gimli.getVida());
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
    
    @Test
    public void dwarfTemDataDeNascimento(){
        Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(10, 10, 1200));
        assertFalse(gimli.getDataNascimento().equals(null));
    }
    
    @Test
    public void dwarfDeAnoBissextoTemSorteCom80DeVida(){
        Dwarf sortudo = new Dwarf("Sortudo", new DataTerceiraEra(10,10,2000));
        double sorteEsperada = -3333.0;
        
        sortudo.receberFlechada();
        sortudo.receberFlechada();
        sortudo.receberFlechada();
        
        assertTrue(sorteEsperada == sortudo.getNumeroSorte());
        
    }
    
    @Test
    public void dwarfSeixasNaoÉDeBissextoETemSorte(){
        Dwarf seixas = new Dwarf("Seixas");
        double sorteEsperada = 33.00;
        
        assertTrue(sorteEsperada == seixas.getNumeroSorte());
    }
    
    @Test
    public void dwarfDeAnoBissextoNaoTemSorteCom110DeVida(){
        Dwarf azarado = new Dwarf("Azarado", new DataTerceiraEra(10,10,2004));
        double sorteEsperada = 101.0;
        
        assertTrue(sorteEsperada == azarado.getNumeroSorte());
    }
}
