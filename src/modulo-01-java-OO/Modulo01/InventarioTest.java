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
    
    @Test
    public void obterEscudoDoInventario(){
        //Arrange
        Inventario mochila = new Inventario();
        Item escudo = new Item("Escudo", 1);
        mochila.adicionarItem(escudo);
        Item itemEsperado = escudo;
        Item itemObtido;
        //Act
        itemObtido = mochila.getItem(0);
        //Assert
        assertSame(itemEsperado, itemObtido);
    }
    
    @Test
    public void obterEscudoEEspadaDoInventario(){
        //Arrange
        Inventario mochila = new Inventario();
        Item escudo = new Item("Escudo", 1);
        Item espada = new Item("Espada", 1);
        mochila.adicionarItem(escudo);
        mochila.adicionarItem(espada);
        Item itemEsperado1 = escudo;
        Item itemEsperado2 = espada;
        Item itemObtido1;
        Item itemObtido2;
        //Act
        itemObtido1 = mochila.getItem(0);
        itemObtido2 = mochila.getItem(1);
        //Assert
        assertSame(itemEsperado1, itemObtido1);
        assertSame(itemEsperado2, itemObtido2);
    }
    
    @Test
    public void itemComMaiorQuantidadeÉAdaga(){
        //Arrange
        Inventario mochila = new Inventario();
        Item adaga = new Item("Adaga", 2);
        mochila.adicionarItem(new Item("Corda", 1));
        mochila.adicionarItem(adaga);
        Item itemEsperado = adaga;
        //Act
        //Assert
        assertSame(itemEsperado, mochila.getItemComMaiorQuantidade());
    }
    
    @Test
    public void inventarioTemDoisItensComQuantidadeIgualOMaiorÉOPrimeiroAdicionado(){
        //Arrange
        Inventario mochila = new Inventario();
        Item adaga = new Item("Adaga", 2);
        
        mochila.adicionarItem(adaga);
        mochila.adicionarItem(new Item("Corda", 2));
        
        Item itemEsperado = adaga;
        //Act
        //Assert
        assertSame(itemEsperado, mochila.getItemComMaiorQuantidade());
    }

}
