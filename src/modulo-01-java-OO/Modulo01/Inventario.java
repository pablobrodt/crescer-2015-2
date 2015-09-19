
import java.util.ArrayList;

public class Inventario{
    
    ArrayList<Item> itens = new ArrayList<Item>();
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    public void perderItem(Item item){
        this.itens.remove(item);
    }
    
    public Item getItem(int itemIndex){
        return this.itens.get(itemIndex);
    }
    
    public int getQuantidadeItens(){
        return this.itens.size();
    }
    
    public String getDescricoesItens(){
        String listaDeItens = "";
        for( Item item : itens ){
            listaDeItens += item.getDescricao();
            listaDeItens += ",";
        }
        if( listaDeItens.length() > 1 ){
        listaDeItens = listaDeItens.substring(0, listaDeItens.length() - 1);
        }
        //System.out.println(listaDeItens);
        return listaDeItens;
    }
    
    public Item getItemComMaiorQuantidade(){
        Item itemComMaisQuantidade = null;
        int maiorQuantidade = 0;
        
        for(Item item : this.itens){
        
            if( item.getQuantidade() > maiorQuantidade ){
            
                itemComMaisQuantidade = item;
                maiorQuantidade = item.getQuantidade();
            
            }
        
        }

        return itemComMaisQuantidade;
    }
   
   public void ordenarItens(){
        int i;
        int j;
    
        for(i=0;i<this.itens.size();i++){
            
            for(j=0;j<this.itens.size()-1;j++){
                
                if( this.itens.get(j).getQuantidade() > this.itens.get(j+1).getQuantidade()  ){
                    Item itemAux = this.itens.get(j);
    
                    this.itens.set( j, this.itens.get(j+1));
                    this.itens.set(j+1, itemAux);
                }
            }
        }
    }
}
