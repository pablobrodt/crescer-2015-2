import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LeprechaunTest
{
    @Test
    public void leprechaunNaoTemSorteENaoGanhaItens(){
        //Arrange
        Leprechaun lepre = new Leprechaun();
        Item lembas = new Item("Lembas", 2);
        lepre.ganhaItem(lembas);
        int quantidadeEsperada = 2;
        int quantidadeObtida;
        //Act
        lepre.tentarSorte();
        quantidadeObtida = lepre.getItem(0).getQuantidade();
        //Assert
        assertEquals(quantidadeEsperada, quantidadeObtida);
    }
    
    @Test
    public void leprechaunTemSorteEGanhaMais1000DeCadaItem(){
        //Arrange
        Leprechaun sortudo = new Leprechaun(new DataTerceiraEra(10,10,2000));
        sortudo.receberFlechada();
        sortudo.receberFlechada();

        sortudo.ganhaItem(new Item("Lembas", 5));
        sortudo.ganhaItem(new Item("Adaga", 2));
        sortudo.ganhaItem(new Item("Poçao", 1));
        
        Item lembas = sortudo.getItem(0);
        Item adaga = sortudo.getItem(1);
        Item pocao = sortudo.getItem(2);
        
        int quantidadeLembasEsperada = 1005;
        int quantidadeAdagasEsperada = 1002;
        int quantidadePoçõesEsperadas = 1001;
        //Act
        sortudo.tentarSorte();
        //Assert
        assertEquals(quantidadeLembasEsperada, lembas.getQuantidade());
        assertEquals(quantidadeAdagasEsperada, adaga.getQuantidade());
        assertEquals(quantidadePoçõesEsperadas, pocao.getQuantidade());
    }
    
}
