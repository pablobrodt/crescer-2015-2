import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcTest
{
    @Test
    public void orcRecebeDanoDeElfo(){
        Orc orc = new Orc();
        int vidaEsperada = orc.getVida()-8;
        if(vidaEsperada < 0){
            vidaEsperada = 0;
        }
        orc.receberAtaqueDeElfo();
        
        assertEquals(vidaEsperada, orc.getVida());
        
    }
    
    @Test
    public void orcSemEscudoRecebeDanoDeAnao(){
        Orc orc = new Orc();
        for(Item item : orc.getInventario().getItens()){
            if(item.getDescricao().equals("Escudo Uruk-Hai")){
                orc.getInventario().perderItem(item);
            }
        }
        int vidaEsperada = orc.getVida()-10;
        if(vidaEsperada < 0){
            vidaEsperada = 0;
        }
        orc.receberAtaqueDeAnao();
        
        assertEquals(vidaEsperada, orc.getVida());
    }
    
    @Test 
    public void orcComEscudoRecebeDanoDeAnao(){
        Orc orc = new Orc();
        orc.getInventario().adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        int vidaEsperada = orc.getVida()-5;
        if(vidaEsperada < 0){
            vidaEsperada = 0;
        }
        orc.receberAtaqueDeAnao();
        
        assertEquals(vidaEsperada, orc.getVida());
    }
    
    @Test
    public void orcMorreQuandoVidaAcaba(){
        Orc orc = new Orc();
        while(orc.getStatus() != Status.MORTO){
            orc.receberAtaqueDeAnao();
        }
        
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void orcComEspadaArcoEFlechasTem12DeDano(){
        Orc orc = new Orc();
        orc.getInventario().adicionarItem(new Item(1, "Espada"));
        orc.getInventario().adicionarItem(new Item(1, "Arco"));
        orc.getInventario().adicionarItem(new Item(1, "Flecha"));
        
        assertEquals(12, orc.danoDoOrc());
    }
    
    @Test
    public void orcComArcoEFlechasTem8DeDano(){
        Orc orc = new Orc();
        for(Item item : orc.getInventario().getItens()){
            if(item.getDescricao().equals("Espada")){
                orc.getInventario().perderItem(item);
            }
        }
        orc.getInventario().adicionarItem(new Item(1, "Arco"));
        orc.getInventario().adicionarItem(new Item(1, "Flecha"));
        
        assertEquals(8, orc.danoDoOrc());
    }
    
  
}
