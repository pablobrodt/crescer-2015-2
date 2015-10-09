import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void pelotao2Verdes2NoturnosVs2Dwarves(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        
        ElfoVerde elfov1 = new ElfoVerde("elfov1");
        ElfoVerde elfov2 = new ElfoVerde("elfov2");
        ElfoNoturno elfon1 = new ElfoNoturno("elfon1");
        ElfoNoturno elfon2 = new ElfoNoturno("elfon2");
        
        exercito.alistar(elfov1);
        exercito.alistar(elfon1);
        exercito.alistar(elfon2);
        exercito.alistar(elfov2);
        
        ArrayList<Elfo> ordemEsperada = new ArrayList<>();
        ordemEsperada.add(elfov1);
        ordemEsperada.add(elfon1);
        ordemEsperada.add(elfov2);
        ordemEsperada.add(elfon2);
        
        Dwarf anao1 = new Dwarf();
        Dwarf anao2 = new Dwarf();
        
        int vidaEsperada = 70;
        
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(anao1);
        anoes.add(anao2);
        
        exercito.atacar( anoes );
        
        assertEquals(ordemEsperada, exercito.getOrdemDoUltimoAtaque());
        
        assertEquals(vidaEsperada, anao1.getVida(), .0);
        assertEquals(vidaEsperada, anao2.getVida(), .0);

    }
    
    
    @Test
    public void pelotao3Verdes2NoturnosNaoAtaca(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        
        ElfoVerde elfov1 = new ElfoVerde("elfov1");
        ElfoVerde elfov2 = new ElfoVerde("elfov2");
        ElfoVerde elfov3 = new ElfoVerde("elfov3");
        ElfoNoturno elfon1 = new ElfoNoturno("elfon1");
        ElfoNoturno elfon2 = new ElfoNoturno("elfon2");
        
        exercito.alistar(elfov1);
        exercito.alistar(elfon1);
        exercito.alistar(elfon2);
        exercito.alistar(elfov2);
        exercito.alistar(elfov3);        
        
        Dwarf anao1 = new Dwarf();
        Dwarf anao2 = new Dwarf();
        
        int vidaEsperada = 110;
        
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(anao1);
        anoes.add(anao2);
        
        exercito.atacar( anoes );
        
        assertEquals(vidaEsperada, anao1.getVida(), .0);
        assertEquals(vidaEsperada, anao2.getVida(), .0);

    }
    /*@Test
    public void pelotao2Verdes1NoturnoVivoE1MortoVs2Dwarves(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        
        ElfoVerde elfov1 = new ElfoVerde("elfov1");
        ElfoVerde elfov2 = new ElfoVerde("elfov2");
        ElfoNoturno elfon1 = new ElfoNoturno("elfon1");
        ElfoNoturno elfon2 = new ElfoNoturno("elfon2");
        
        for(int i =0; i<=100; i++){
            elfon2.atirarFlecha(new Dwarf());
        }
        
        exercito.alistar(elfov1);
        exercito.alistar(elfon1);
        exercito.alistar(elfon2);
        exercito.alistar(elfov2);
        
        ArrayList<Elfo> ordemEsperada = new ArrayList<>();
        ordemEsperada.add(elfov1);
        ordemEsperada.add(elfon1);
        ordemEsperada.add(elfov2);
        
        Dwarf anao1 = new Dwarf();
        Dwarf anao2 = new Dwarf();
        
        int vidaEsperada = 80;
        
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(anao1);
        anoes.add(anao2);
        
        exercito.atacar( anoes );
        
        assertEquals(ordemEsperada, exercito.getOrdemDoUltimoAtaque());
        
        assertEquals(vidaEsperada, anao1.getVida(), .0);
        assertEquals(vidaEsperada, anao2.getVida(), .0);

    }*/
    
}
