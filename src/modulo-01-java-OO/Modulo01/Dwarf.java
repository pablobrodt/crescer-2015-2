public class Dwarf {
    private int vida = 110;
    Status status = Status.VIVO;
    private String nome;
    private int experiencia = 0;
    
    public Dwarf( String nome ){
        this.nome = nome;
    }
    
    public void receberFlechada() {
        this.vida -= 10;
        if( this.vida == 0 ){
            
            this.status = Status.MORTO;
        
        }
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}