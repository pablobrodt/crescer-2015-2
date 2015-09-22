
public class UrukHai extends Orc
{
    public UrukHai(){
        this.vida = 150;
        this.inventario.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        this.inventario.adicionarItem(new Item(1, "Espada"));
    }
}
