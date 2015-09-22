import java.util.Random;
/**
 * Escreva a descrição da classe orc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    protected Status status = Status.VIVO;
    protected Inventario inventario = new Inventario();

    /**
     * COnstrutor para objetos da classe orc
     */ 
    
    public Orc(){
        if( !verificarItens("Espada") && !verificarItens("Arco")){
            this.status = Status.FUGINDO;
        }
    }
    
    /*
    public void gerarVida() {
        Random geraVida = new Random();
        this.vida = geraVida.nextInt( 150 );
    }
    
    public void gerarItens(){
        Random item = new Random();
        Random quantidade = new Random();
        int qtd;
        
        qtd = quantidade.nextInt(2);
        if(item.nextInt(2) > 1 && qtd > 0){
            inventario.adicionarItem(new Item(qtd,"Escudo Uruk-Hai"));
        }
        
        qtd = quantidade.nextInt(2);
        if(item.nextInt(2) < 1 && qtd > 0){
            inventario.adicionarItem(new Item(qtd,"Espada"));
        }
        
        qtd = quantidade.nextInt(2);
        if(item.nextInt(2) > 1 && qtd > 0){
            inventario.adicionarItem(new Item(qtd,"Arco"));
        }
        
        qtd = quantidade.nextInt(100);
        if(item.nextInt(2) < 1 && qtd > 0){
            inventario.adicionarItem(new Item(qtd,"Flecha"));
        }

    }*/
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    
    
    public boolean verificarItens(String descricaoDoItem){
        boolean retorno = false;
        for(Item item : this.inventario.getItens()){
            if(item.getDescricao().equals(descricaoDoItem) && item.getQuantidade() > 0){
                retorno = true;
            }
        }
        
        return retorno;
    }
    
    public void confereVida(){
        if(this.vida <= 0){
            status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    public void receberAtaqueDeAnao() {
        if(this.verificarItens("Escudo Uruk-Hai")){
            this.vida -= 5;
        }else{
            this.vida -= 10;
        }
        confereVida();
        
    }
    
    public void receberAtaqueDeElfo(){
        this.vida -= 8;
        confereVida();
    }
    
    public int danoDoOrc(){
        int dano = 0;
       
        if( this.verificarItens("Espada") ){
            dano = 12;
            return dano;
        }
        if( this.verificarItens("Arco") && this.verificarItens("Flecha") ){
            dano = 8;
            perder1UnidadeDeFlecha();
            return dano;
        }        
        return dano;
    }
    
    public void perder1UnidadeDeFlecha(){
        for(Item item : this.inventario.getItens()){
            if( item.getDescricao().equals("Flecha") && item.getQuantidade() > 0){
                item.perder1Unidade();
                if(item.getQuantidade() == 0){
                    this.inventario.perderItem(item);
                }
            }
        }
    }
    
    public void atacaElfo(Elfo alvo){
        alvo.receberAtaqueOrc(this);
    }
    
    public void atacaAnao(Dwarf alvo){
        alvo.receberAtaqueOrc(this);
    }

    
    
}