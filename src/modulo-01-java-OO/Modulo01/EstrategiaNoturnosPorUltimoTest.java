import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaNoturnosPorUltimoTest
{   
    
    @Test
    public void ataqueCom2ElfosVerdesE1ElfoNoturnoÀ3Dwarves(){
    
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia( new EstrategiaNoturnosPorUltimo() );
        
        ElfoVerde elfo1 = new ElfoVerde("Verdao");
        ElfoNoturno elfo3 = new ElfoNoturno("Noitao");
        ElfoVerde elfo2 = new ElfoVerde("Verde");
        
        exercito.alistar(elfo1);
        exercito.alistar(elfo3);
        exercito.alistar(elfo2);
        
        Dwarf anao1 = new Dwarf();
        Dwarf anao2 = new Dwarf();
        
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add( anao1 );
        dwarves.add( anao2 );
        
        exercito.atacar(dwarves);
        
        int vidaEsperada = 80;
        
        ArrayList<Elfo> ordemEsperada = new ArrayList<>();
        ordemEsperada.add(elfo1);
        ordemEsperada.add(elfo2);
        ordemEsperada.add(elfo3);
        
        //verifica vida dos anoes
        assertEquals(vidaEsperada, anao1.getVida(), .0);
        assertEquals(vidaEsperada, anao2.getVida(), .0);
        
        //verifica ordem do ultimo ataque
        assertEquals( ordemEsperada.get(0), exercito.getOrdemDoUltimoAtaque().get(0) );
        assertEquals( ordemEsperada.get(1), exercito.getOrdemDoUltimoAtaque().get(1) );
        assertEquals( ordemEsperada.get(2), exercito.getOrdemDoUltimoAtaque().get(2) );
       
        
        
    }
}
