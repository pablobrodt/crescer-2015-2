import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContadorTest
{
    @Test
    public void existemMuitosElfos(){
        int quantidadeEsperada = Contador.quantidadeDeElfos+1;
        
        new Elfo("mais um");
        
        assertEquals(quantidadeEsperada, Contador.quantidadeDeElfos);
    }
}
