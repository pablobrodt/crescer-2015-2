/**
 * Representa objetos do tipo Elfo.
 */

public class Elfo {
    private String nome;
    private int flechas, experiencia;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
   
    public Elfo(String nome) {
        this(nome, 42);
    }
   
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
    }
    /*
     * Exemplo de construtor com Integer, para que possa receber parametro null
     * public Elfo(String nome, Integer flechas) {
     *  this(nome);
     *  if (flechas != null) {
     *      this.flechas = flechas;
     *  }
     * }
    
     * PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.receberFlechada();
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
    

    public String getNome() {
        return nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public String toString(){
        String retorno = "";
        
        retorno += this.nome;
        retorno += " possui ";
        retorno += this.flechas;
        retorno += " flechas e ";
        retorno += this.experiencia;
        retorno += " niveis de experiência.";
        
        return retorno;
    }
    
    /*
     * 
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }
     *
     * public void atirarFlechaRefactory(){
     *  boolean acertar = true;
     *  if (acertar) {
     *      experiencia++;
     *  }
     *  flechas--;
     * }
    */
   
}
