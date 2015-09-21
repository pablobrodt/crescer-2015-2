import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfMuitoSortudoCom1ItemDeQuantidade3(){
        //Arrange
        IrishDwarf sortudo = new IrishDwarf("Sortudo", new DataTerceiraEra(1,1,2000));
        Item chapeu = new Item(3, "Chapéu");
        sortudo.adicionarItem( chapeu );
        sortudo.receberFlechada();
        sortudo.receberFlechada();
        
        Inventario inventarioDoSortudo = sortudo.getInventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem( new Item(6003, "Chapéu"));
        
        //Act
        sortudo.tentarSorte();
        
        //Assert
        assertEquals(esperado, inventarioDoSortudo);
    }
    
    @Test
    public void irishDwarfMuitoSortudoCom3ItemEQtdsDiferentes(){
        //Arrange
        IrishDwarf sortudo = new IrishDwarf("Sortudo", new DataTerceiraEra(1,1,2000));
        
        Item chapeu = new Item(3, "Chapéu");
        Item lembas = new Item(5, "Lembas");
        Item corda = new Item(2, "Corda");
        
        sortudo.adicionarItem( chapeu );
        sortudo.adicionarItem( lembas );
        sortudo.adicionarItem( corda );
        
        sortudo.receberFlechada();
        sortudo.receberFlechada();
        
        Inventario inventarioDoSortudo = sortudo.getInventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem( new Item(6003, "Chapéu"));
        esperado.adicionarItem( new Item(15005, "Lembas"));
        esperado.adicionarItem( new Item(3002, "Corda"));
        
        //Act
        sortudo.tentarSorte();
        
        //Assert
        assertEquals(esperado, inventarioDoSortudo);
    }
    

}
