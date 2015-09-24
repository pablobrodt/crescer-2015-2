import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContadorTest
{
    @Test
    public void existemMuitosElfos(){
        Contador.resetar();
        
        int quantidadeEsperada = 1;
        
        new Elfo("mais um");
        
        assertEquals(quantidadeEsperada, Contador.getQtdElfos());
    }
}
