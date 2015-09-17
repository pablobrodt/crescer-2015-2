

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
    
    Dwarf gimli;
    Dwarf gloin;
    
    Elfo legolas;
    Elfo thranduil;
    
    public ElfoTest(){
        
        gimli = new Dwarf();
        gloin = new Dwarf();
        
        legolas = new Elfo( "Legolas" );
        thranduil = new Elfo( "Thranduil", 7 );
        
        elfos.add( legolas );
        elfos.add( thranduil );
        

        
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
    public void elfoNasceCom42Flechas(){
        Elfo elfis = new Elfo("Elfis");
        assertEquals(42, elfis.getFlechas());
    }
    
    
    @Test
    public void elfoNasceSemXp(){
        Elfo galadriel = new Elfo( "Galadriel" );
        assertTrue(galadriel.getExperiencia() == 0 );
    }
        
    
    
    @Test
    public void elfoAtiraFlechaMachucaDwarfEGanhaXp(){     
        int flechas = legolas.getFlechas();
        int exp = legolas.getExperiencia();
        int vidaDwarf = gimli.getVida();
        
        legolas.atirarFlecha(gimli);
        
        assertTrue( flechas > legolas.getFlechas());
        assertTrue( exp < legolas.getExperiencia());
        assertTrue( vidaDwarf > gimli.getVida() );  
    }
    
    
    @Test
    public void elfosAtiramFlechasEmUmDwarfEGanhamXp(){
        
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
    public void elfosAtacamDwarvesDiferentesGastamFlechasEGanhamXp(){
        int vidaGimli = gimli.getVida();
        int vidaGloin = gloin.getVida();
        
        int flechasLegolas = legolas.getFlechas();
        int flechasThranduil = thranduil.getFlechas();
        
        int expLegolas = legolas.getExperiencia();
        int expThranduil = thranduil.getExperiencia();
        
        legolas.atirarFlecha(gimli);
        thranduil.atirarFlecha(gloin);
        
        assertTrue( flechasLegolas > legolas.getFlechas());
        assertTrue( expLegolas < legolas.getExperiencia());
        assertTrue( vidaGimli > gimli.getVida() );
        
        assertTrue( flechasThranduil > thranduil.getFlechas());
        assertTrue( expThranduil < thranduil.getExperiencia());
        assertTrue( vidaGloin > gloin.getVida() );
    }
    
    @Test
    public void elfoAtiraEmDoisDwarvesCausaDanoEGanhaXp(){
        int vidaGimli = gimli.getVida();
        int vidaGloin = gloin.getVida();
        
        int flechasLegolas = legolas.getFlechas();
        int expLegolas = legolas.getExperiencia();
        
        legolas.atirarFlecha(gimli);
        legolas.atirarFlecha(gloin);
        
        assertTrue( flechasLegolas > legolas.getFlechas());
        assertTrue( expLegolas < legolas.getExperiencia());
        
        assertTrue( vidaGimli > gimli.getVida() );
        assertTrue( vidaGloin > gloin.getVida() );
    }

    
    
    @Test
    public void elfosToString(){
        for( Elfo elfo : elfos ){
            String teste;
            teste = elfo.getNome() + " possui ";
            teste += elfo.getFlechas() + " flechas e ";
            teste += elfo.getExperiencia() + " niveis de experiência.";
            
            assertEquals( teste, elfo.toString() );
        }
    }
    
    @Test
    public void elfosToStringAposAtirarFlechasEGanharXp(){
        for( Elfo elfo : elfos ){
            
            elfo.atirarFlecha(gimli);
            
            String teste;
            teste = elfo.getNome() + " possui ";
            teste += elfo.getFlechas() + " flechas e ";
            teste += elfo.getExperiencia() + " niveis de experiência.";
            
            assertEquals( teste, elfo.toString() );
        }
    }
    
    @Test
    public void elfoNaoEstaAtirandoFlechas(){
        int flechas = legolas.getFlechas();
        legolas.atirarFlecha(gimli);
        assertTrue(flechas == legolas.getFlechas());
    }
    
    
    
    

    

   
    
    
}
