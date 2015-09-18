

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest
{
   
    @Test
    public void anoBissextoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 10, 2000);
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void anoNaoBissextoNaoÉBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10, 10, 1991);
        assertFalse(data.ehBissexto());
    }
    
}
