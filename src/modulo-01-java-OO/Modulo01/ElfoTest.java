

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class ElfoTest
{
    
    ArrayList<Elfo> elfos = new ArrayList<Elfo>();
    
    public ElfoTest(){
        elfos.add(new Elfo( "Legolas" ));
        elfos.add(new Elfo( "Halorino", 7 ));
        elfos.add(new Elfo( "Enéias", null ));
        elfos.add(new Elfo( "José", new Integer(89) ));
    }
    

    @Test
    public void elfoTemNomeEFlechas(){
        
        for( Elfo elfo : elfos){
            assertNotNull(elfo.getNome());
            assertNotSame("",elfo.getNome());
            assertTrue( elfo.getFlechas() > 0);
        }

    }
    
    @Test
    public void elfoAtiraFlechaMachucaDwarfEGanhaXp(){
    
        Dwarf gimli = new Dwarf();
        
        for( Elfo elfo : elfos ){
            int flechas = elfo.getFlechas();
            int exp = elfo.getExperiencia();
            int vidaDwarf = gimli.getVida();
            elfo.atirarFlecha(gimli);
            assertTrue( flechas > elfo.getFlechas());
            assertTrue( exp < elfo.getExperiencia());
            assertTrue( vidaDwarf > gimli.getVida() );
        }
    
    }

    
    
    @Test
    public void elfoToString(){
        for( Elfo elfo : elfos ){
            String teste;
            teste = elfo.getNome() + " possui ";
            teste += elfo.getFlechas() + " flechas e ";
            teste += elfo.getExperiencia() + " niveis de experiência.";
            
            assertEquals( teste, elfo.toString() );
        }
    }
    

   
    
    
}
