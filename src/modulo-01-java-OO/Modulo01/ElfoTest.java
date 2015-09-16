

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
    public void elfoTemNome(){
        
        for( Elfo elfo : elfos){
            assertNotNull(elfo.getNome());    
        }

    }
    
    @Test
    public void elfoTemFlechas(){
    
        for( Elfo elfo : elfos){
            assertTrue( elfo.getFlechas() > 0);    
        }
    
    }
    
    @Test
    public void elfoAtiraFlecha(){
    
        Dwarf gimli = new Dwarf();
        
        for( Elfo elfo : elfos ){
            int flechas = elfo.getFlechas();
            elfo.atirarFlecha(gimli);
            assertTrue( flechas > elfo.getFlechas());
        }
    
    }
    
    @Test
    public void elfoGanhaXp(){
    
        Dwarf gimli = new Dwarf();
        
        for( Elfo elfo : elfos ){
            int exp = elfo.getExperiencia();
            elfo.atirarFlecha(gimli);
            assertTrue( exp < elfo.getExperiencia());
        }
    
    }
    
    @Test
    public void elfoAtiraFlechaRefactory(){
        for( Elfo elfo : elfos){
            int flechas = elfo.getFlechas();
            elfo.atirarFlechaRefactory();
            assertTrue( flechas > elfo.getFlechas());
        }
    }
    
    @Test
    public void elfoGanhaXpRefactory(){
        for( Elfo elfo : elfos){
            int exp = elfo.getExperiencia();
            elfo.atirarFlechaRefactory();
            assertTrue( exp < elfo.getExperiencia());
        }
    }
    
    

   
    
    
}
