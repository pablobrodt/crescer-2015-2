import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    
}
