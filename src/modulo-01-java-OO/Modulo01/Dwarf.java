
/**
 * Escreva a descrição da classe Dwarves aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Dwarf
{
    private String nome;
    private int vida;
    
    {
        this.vida = 110;
    }
    
    public Dwarf( String nome ){
    
        this.nome = nome;
    
    }
    

    
    public int getVida(){
    
        return this.vida;
    
    }
    
    public void sofreDano(){

         this.vida -= 10;
 
    }
    
}
