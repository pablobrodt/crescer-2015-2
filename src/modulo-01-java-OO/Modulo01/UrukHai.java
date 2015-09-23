
public class UrukHai extends Orc
{
   //Um UrukHai devem continuar começando com 150 de vida, um item Espada e um item Escudo Uruk-Hai
   public UrukHai(){
       this.vida = 150;
       this.inventario.adicionarItem(new Item(1, "Espada"));
       this.inventario.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
   }
}
