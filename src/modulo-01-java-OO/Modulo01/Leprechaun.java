
public class Leprechaun extends Dwarf
{
    
    public Leprechaun(){
        super(null);
    }
    
    public Leprechaun(DataTerceiraEra dataNascimento){
        super(null, dataNascimento);
    }
    
    public void tentarSorte(){
        int i;
        if( this.gerarNumero() == -3333 ){
            for(i=0;i<this.inventario.getQuantidadeItens();i++){
               Item item = this.inventario.getItem(i);
               int novaQuantidade = item.getQuantidade() + 1000;
               item.setQuantidade(novaQuantidade);
            }
        }
    }

}
