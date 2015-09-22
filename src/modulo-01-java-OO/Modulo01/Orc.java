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
    protected int dano;

    /**
     * COnstrutor para objetos da classe orc
     */ 
    /*
    public Orc(){
        gerarVida();
        
        gerarItens();
    }
    
    
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
    
    public boolean temEscudo(){
        boolean retorno = false;
        for(Item item : this.inventario.getItens()){
            if(item.getDescricao().equals("Escudo Uruk-Hai") && item.getQuantidade() > 0){
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
        if(this.temEscudo()) {
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
        this.dano = 0;
        Item arco = null;
        Item flecha = null;
        Item espada = null;
        
        for(Item item : inventario.getItens()){
            if( item.getDescricao().equals("Arco")){
                arco = item;
            }
            if( item.getDescricao().equals("Flecha")){
                flecha = item;
            }
            if( item.getDescricao().equals("Espada")){
                espada = item;
            }
        }
       
        if( espada != null && espada.getQuantidade() > 0){
            this.dano = 12;
            return this.dano;
        }
        if( flecha != null && flecha.getQuantidade() > 0 && arco != null && arco.getQuantidade() > 0){
            this.dano = 8;
            perder1UnidadeDeFlecha(flecha);
            return this.dano;
        }
        
        return this.dano;
       
    }
    
    public void perder1UnidadeDeFlecha(Item flecha){
        int quantidade = flecha.getQuantidade() -1;
        String descricao = flecha.getDescricao();
        inventario.getItens().remove(flecha);
        if( quantidade > 0){
            inventario.adicionarItem(new Item(quantidade, descricao));
        }
    }
    
    public void atacaElfo(Elfo alvo){
        alvo.receberAtaqueOrc(this);
    }
    
    public void atacaAnao(Dwarf alvo){
        alvo.receberAtaqueOrc(this);
    }

    
    
}