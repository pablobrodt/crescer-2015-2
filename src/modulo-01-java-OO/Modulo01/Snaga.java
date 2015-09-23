
public class Snaga extends Orc
{
    //Um Snaga devem continuar começando com 70 de vida, um item Arco e 5 itens Flecha.
    public Snaga(){
        super();
        this.vida = 70;
        this.inventario.adicionarItem(new Item(1, "Arco"));
        this.inventario.adicionarItem(new Item(5, "Flecha"));
    }
}
