
public class Personagem
{
    protected String nome;
    protected int vida, experiencia;
    protected Status status;
    protected Inventario inventario = new Inventario();
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void confereVida(){
        if(this.vida == 0){
            status = Status.MORTO;
        }
    }
    
    public void receberAtaqueOrc(Orc orc){
        this.vida -= orc.danoDoOrc();
        confereVida();
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
}
