import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaDoGeneralTest
{   
    
    @Test
    public void pelotao3ElfosVerdes2NoturnosAtacaPelotaoDe5Dwarves(){
        //Arrange 
        ElfoVerde soldado1 = new ElfoVerde("Verdovsk");
        ElfoVerde soldado2 = new ElfoVerde("Verdun");   
        ElfoVerde soldado3 = new ElfoVerde("Verdenovo");   
        ElfoNoturno soldado4 = new ElfoNoturno("Noturno");   
        ElfoNoturno soldado5 = new ElfoNoturno("Madruga");
        
        Dwarf alvo1 = new Dwarf();
        Dwarf alvo2 = new Dwarf();
        Dwarf alvo3 = new Dwarf();
        
        ArrayList<Elfo> elfosEsperados = new ArrayList<Elfo>(Arrays.asList(soldado3, soldado2, soldado1, soldado5, soldado4));
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>(Arrays.asList(alvo1, alvo2, alvo3));
        
        double vidaEsperadaAlvo1 = 60;
        double vidaEsperadaOutrosAlvos = 70;
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.mudarEstrategia(new EstrategiaDoGeneral());
        
        exercito.alistar(soldado1);
        exercito.alistar(soldado2);
        exercito.alistar(soldado3);
        exercito.alistar(soldado4);
        exercito.alistar(soldado5);
        
        //Act
        exercito.atacar(dwarves);
        
        //Assert
        assertEquals(vidaEsperadaAlvo1, alvo1.getVida(), .0);
        assertEquals(vidaEsperadaOutrosAlvos, alvo2.getVida(), .0);
        assertEquals(vidaEsperadaOutrosAlvos, alvo3.getVida(), .0);
    }
    
    @Test
    public void pelotaoCom1ElfoVivoAtacaPelotaoDe2Dwarves(){
        //Arrange  
        ElfoNoturno soldado4 = new ElfoNoturno("Noturno");   
        ElfoNoturno soldado5 = new ElfoNoturno("Madruga");
        
        while( soldado4.getStatus() != Status.MORTO){
            soldado4.atirarFlecha(new Dwarf());
        }
        
        Dwarf alvo1 = new Dwarf();
        Dwarf alvo2 = new Dwarf();
        
        ArrayList<Elfo> elfosEsperados = new ArrayList<Elfo>(Arrays.asList(soldado5, soldado4));
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>(Arrays.asList(alvo1, alvo2));
        
        double vidaEsperadaAlvo1 = 100;
        double vidaEsperadaAlvo2 = 110;
        
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.mudarEstrategia(new EstrategiaDoGeneral());
        
        exercito.alistar(soldado4);
        exercito.alistar(soldado5);
        
        //Act
        exercito.atacar(dwarves);
        
        //Assert
        assertEquals(vidaEsperadaAlvo1, alvo1.getVida(), .0);
        assertEquals(vidaEsperadaAlvo2, alvo2.getVida(), .0);
    }
}
