
public class Item
{
    String descricao;
    int quantidade;
    
    public Item( String descricao, int quantidade ){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}
