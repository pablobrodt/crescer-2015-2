public class Snaga extends Orc
{
   public Snaga(){
       this.vida = 70;
       this.inventario.adicionarItem(new Item(1, "Arco"));
       this.inventario.adicionarItem(new Item(5, "Flecha"));
   }
}
