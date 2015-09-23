
public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf alvo){
        super.atirarFlecha(alvo);
        this.experiencia += 2;
        this.vida -= this.vida*0.05;
        verificaVida();
    }
    
    public void verificaVida(){
        if(this.vida <= 0){
            this.status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    /**
     * Atualmente não há nenhum metodo que altere
     * o status de um elfo
    */
   
    
}
