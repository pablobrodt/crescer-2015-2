import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.ArrayList;

public class ExercitoDeElfosTest
{
    /**
     * Alistar ElfoVerde
    */
   @Test
   public void alistarElfoVerdeAoExercito(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoVerde("Verde"));
       
       ExercitoDeElfos exercitoEsperado = new ExercitoDeElfos();
       exercitoEsperado.alistarElfo(new ElfoVerde("Verde"));
       
       assertEquals(exercitoEsperado, exercito);
       
   }
   
   /**
     * Alistar ElfoNoturno
    */
   @Test
   public void alistarElfoNoturnoAoExercito(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoNoturno("Noturno"));
       
       ExercitoDeElfos exercitoEsperado = new ExercitoDeElfos();
       exercitoEsperado.alistarElfo(new ElfoNoturno("Noturno"));
       
       assertEquals(exercitoEsperado, exercito);
       
   }
   
   /**
     * Obter ElfoVerde
    */
   @Test
   public void obterElfoVerdeDoExercito(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoVerde("Verde"));
       
       ElfoVerde elfoEsperado = new ElfoVerde("Verde");
       ElfoVerde elfoObtido = (ElfoVerde) exercito.getElfoByNome("Verde");
       
       assertEquals(elfoEsperado, elfoObtido);
       
   }
   
   /**
     * Obter ElfoNoturno
    */
   @Test
   public void obterElfoNoturnoDoExercito(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoNoturno("Noturno"));
       
       ElfoNoturno elfoEsperado = new ElfoNoturno("Noturno");
       ElfoNoturno elfoObtido = (ElfoNoturno) exercito.getElfoByNome("Noturno");
       
       assertEquals(elfoEsperado, elfoObtido);
       
   }
   
   /**
    * Exercito com 3 Elfos Verdes
    */
   @Test
   public void exercitoTem3ElfosVerdes(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoVerde("Verde"));
       exercito.alistarElfo(new ElfoVerde("Azul Esverdeado"));
       exercito.alistarElfo(new ElfoVerde("Verde Azulado"));
       
       ExercitoDeElfos exercitoEsperado = new ExercitoDeElfos();
       exercitoEsperado.alistarElfo(new ElfoVerde("Verde"));
       exercitoEsperado.alistarElfo(new ElfoVerde("Azul Esverdeado"));
       exercitoEsperado.alistarElfo(new ElfoVerde("Verde Azulado"));
       
       assertEquals(exercitoEsperado, exercito);
       
   }
   
   /**
    * Exercito com 3 Elfos Noturnos
    */
   @Test
   public void exercitoTem3ElfosNoturnos(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoNoturno("Noite"));
       exercito.alistarElfo(new ElfoNoturno("Madrugada"));
       exercito.alistarElfo(new ElfoNoturno("Tardinha"));
       
       ExercitoDeElfos exercitoEsperado = new ExercitoDeElfos();
       exercitoEsperado.alistarElfo(new ElfoNoturno("Noite"));
       exercitoEsperado.alistarElfo(new ElfoNoturno("Madrugada"));
       exercitoEsperado.alistarElfo(new ElfoNoturno("Tardinha"));
       
       assertEquals(exercitoEsperado, exercito);
       
   }
   
   /**
    * Exercito com 2 Elfos Verdes e 1 Elfo Noturno
    */
   @Test
   public void exercitoTem2ElfosVerdesE1ElfoNoturno(){
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.alistarElfo(new ElfoVerde("Verde"));
       exercito.alistarElfo(new ElfoNoturno("Madrugada"));
       exercito.alistarElfo(new ElfoVerde("Verde Claro"));
       
       ExercitoDeElfos exercitoEsperado = new ExercitoDeElfos();
       exercitoEsperado.alistarElfo(new ElfoVerde("Verde"));
       exercitoEsperado.alistarElfo(new ElfoNoturno("Madrugada"));
       exercitoEsperado.alistarElfo(new ElfoVerde("Verde Claro"));
       
       assertEquals(exercitoEsperado, exercito);
       
   }
   
   /**
    * Ordenar Exercito com 3 Elfos mortos e 3 Elfos vivos
    */
    @Test
    public void exercitoCom3ElfosVivosE3ElfosMortosOrdenado(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.alistarElfo(new ElfoVerde("v1"));
        exercito.alistarElfo(new ElfoVerde("v2"));
        exercito.alistarElfo(new ElfoVerde("v3"));
        
        ElfoNoturno morto1 = new ElfoNoturno("n1");
        ElfoNoturno morto2 = new ElfoNoturno("n2");
        ElfoNoturno morto3 = new ElfoNoturno("n3");
        
        while(morto1.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO ){
            morto1.atirarFlecha(new Dwarf());
            morto2.atirarFlecha(new Dwarf());
            morto3.atirarFlecha(new Dwarf());
        }
        
        exercito.alistarElfo(morto1);
        exercito.alistarElfo(morto2);
        exercito.alistarElfo(morto3);
        
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        ArrayList<Elfo> vivos = new ArrayList<>();
        ArrayList<Elfo> mortos = new ArrayList<>();
        
        vivos.add(new ElfoVerde("v1"));
        vivos.add(new ElfoNoturno("v2"));
        vivos.add(new ElfoVerde("v3"));
        
        mortos.add(morto1);
        mortos.add(morto2);
        mortos.add(morto3);
        
        esperado.put(Status.VIVO, vivos);
        esperado.put(Status.MORTO, mortos);
        
        exercito.agruparPorStatus();
        
        assertEquals(esperado, exercito.getExercitoPorStatus());
        
    }
    
    /**
     * Obter a lista de elfos vivos
     */
    @Test
    public void obterElfosVivos(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.alistarElfo(new ElfoVerde("v1"));
        exercito.alistarElfo(new ElfoVerde("v2"));
        exercito.alistarElfo(new ElfoVerde("v3"));
        
        ElfoNoturno morto1 = new ElfoNoturno("n1");
        ElfoNoturno morto2 = new ElfoNoturno("n2");
        ElfoNoturno morto3 = new ElfoNoturno("n3");
        
        while(morto1.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO ){
            morto1.atirarFlecha(new Dwarf());
            morto2.atirarFlecha(new Dwarf());
            morto3.atirarFlecha(new Dwarf());
        }
        
        exercito.alistarElfo(morto1);
        exercito.alistarElfo(morto2);
        exercito.alistarElfo(morto3);
        
        ArrayList<Elfo> vivos = new ArrayList<>();
        
        vivos.add(new ElfoVerde("v1"));
        vivos.add(new ElfoNoturno("v2"));
        vivos.add(new ElfoVerde("v3"));
        
        exercito.agruparPorStatus();
        
        assertEquals(vivos, exercito.buscar(Status.VIVO));
    }
    
    /**
     * Obter a lista de elfos mortos
     */
    @Test
    public void obterElfosMortos(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        exercito.alistarElfo(new ElfoVerde("v1"));
        exercito.alistarElfo(new ElfoVerde("v2"));
        exercito.alistarElfo(new ElfoVerde("v3"));
        
        ElfoNoturno morto1 = new ElfoNoturno("n1");
        ElfoNoturno morto2 = new ElfoNoturno("n2");
        ElfoNoturno morto3 = new ElfoNoturno("n3");
        
        while(morto1.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO ){
            morto1.atirarFlecha(new Dwarf());
            morto2.atirarFlecha(new Dwarf());
            morto3.atirarFlecha(new Dwarf());
        }
        
        exercito.alistarElfo(morto1);
        exercito.alistarElfo(morto2);
        exercito.alistarElfo(morto3);
      
        ArrayList<Elfo> mortos = new ArrayList<>();
        
        mortos.add(morto1);
        mortos.add(morto2);
        mortos.add(morto3);
        
        exercito.agruparPorStatus();
        
        assertEquals(mortos, exercito.buscar(Status.MORTO));
    }
}
