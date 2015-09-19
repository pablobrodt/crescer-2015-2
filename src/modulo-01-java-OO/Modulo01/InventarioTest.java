import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{   
    @Test
    public void inventarioAdiciona1Item(){
        //Arrange
        Inventario mochila = new Inventario();
        Item lembas = new Item("Lembas", 1);
        int qtdItensEsperados = 1;
        //Act
        mochila.adicionarItem(lembas);
        //Assert
        assertEquals(qtdItensEsperados,mochila.getQuantidadeItens());
    }
    
    @Test
    public void inventarioAdiciona10Itens(){
        //Arrang
        Inventario mochila = new Inventario();
        int qtdItensEsperados = 10;
        //Act
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Corda Élfica", 1));
        mochila.adicionarItem(new Item("Outra Lemba", 1));
        mochila.adicionarItem(new Item("Luz de Eärendil", 1));
        mochila.adicionarItem(new Item("Arco de Galadhrim", 1));
        mochila.adicionarItem(new Item("Fio de Cabelo de Galadriel", 1));
        mochila.adicionarItem(new Item("Adaga Élfica", 1));
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Lembas", 1));
        //Assert
        assertEquals(qtdItensEsperados,mochila.getQuantidadeItens());
    }
    
    @Test
    public void inventarioTem1ItemPerde1EFicaCom0(){
        //Arrange
        Inventario mochila = new Inventario();
        Item lembas = new Item("Lembas", 1);
        mochila.adicionarItem(lembas);
        //Act
        mochila.perderItem(lembas);
        //Assert
        assertEquals(0,mochila.getQuantidadeItens());
    }
    
    @Test
    public void inventarioTem10ItensPerde3EFicaCom7(){
        //Arrange
        Inventario mochila = new Inventario();
        
        Item corda = new Item("Corda Élfica", 1);
        Item luzEarendil = new Item("Luz de Eärendil", 1);
        Item cabeloGaladriel = new Item("Fio de Cabelo de Galadriel", 1);
        
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Outras Lembas", 1));
        mochila.adicionarItem(corda);
        mochila.adicionarItem(new Item("Arco de Galadhrim", 1));
        mochila.adicionarItem(new Item("Fio de Cabelo de Galadriel", 1));
        mochila.adicionarItem(luzEarendil);
        mochila.adicionarItem(new Item("Adaga Élfica", 1));
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(cabeloGaladriel);
        mochila.adicionarItem(new Item("Fio de Cabelo de Galadriel", 1));
        
        int qtdItensEsperados = 7;
        //Act
        mochila.perderItem(corda);
        mochila.perderItem(luzEarendil);
        mochila.perderItem(cabeloGaladriel);        
        //Assert
        assertEquals(qtdItensEsperados,mochila.getQuantidadeItens());
    }
    
    @Test
    public void descricaoDoInventarioSemItens(){
        Inventario mochila = new Inventario();
        String descricaoEsperada = "";
        
        assertEquals(descricaoEsperada, mochila.getDescricoesItens());
    }
    
    @Test
    public void descricaoDoInventarioCom3Itens(){
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Fio de Cabelo de Galadriel", 1));
        mochila.adicionarItem(new Item("Arco de Galadhrim", 1));
        
        String descricaoEsperada = "Lembas,Fio de Cabelo de Galadriel,Arco de Galadhrim";
        
        assertEquals(descricaoEsperada, mochila.getDescricoesItens());
    }
    
    @Test
    public void descricaoDoInventarioCom10Itens(){
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item("Lembas", 1));
        mochila.adicionarItem(new Item("Fio de Cabelo de Galadriel", 1));
        mochila.adicionarItem(new Item("Arco de Galadhrim", 1));
        mochila.adicionarItem(new Item("Corda Élfica", 1));
        mochila.adicionarItem(new Item("Luz de Eärendil", 1));
        mochila.adicionarItem(new Item("Adaga Élfica", 1));
        mochila.adicionarItem(new Item("Outras Lembas", 1));
        mochila.adicionarItem(new Item("Especiaria do Condado", 1));
        mochila.adicionarItem(new Item("Mais Lembas", 1));
        mochila.adicionarItem(new Item("Item qualquer", 1));
        
        String descricaoEsperada = "Lembas,Fio de Cabelo de Galadriel,Arco de Galadhrim,Corda Élfica,Luz de Eärendil,Adaga Élfica,Outras Lembas,Especiaria do Condado,Mais Lembas,Item qualquer";
        
        assertEquals(descricaoEsperada, mochila.getDescricoesItens());
    }

}
