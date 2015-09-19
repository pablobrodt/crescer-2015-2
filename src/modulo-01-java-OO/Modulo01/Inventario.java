
import java.util.ArrayList;

public class Inventario{
    
    ArrayList<Item> itens = new ArrayList<Item>();
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    public void perderItem(Item item){
        this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
}
