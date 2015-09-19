
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
    
}
