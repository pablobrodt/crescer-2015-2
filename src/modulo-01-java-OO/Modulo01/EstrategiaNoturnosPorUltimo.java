import java.util.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque{
    
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
                
        for( Elfo elfo : ordenarAtaque( pelotao ) ){
            
            ordemDoUltimoAtaque.add(elfo);
            
            for( Dwarf dwarf : dwarves ){
                elfo.atirarFlecha(dwarf);
            }
        }
    }    

    private ArrayList<Elfo> ordenarAtaque( ArrayList<Elfo> pelotao){
        ArrayList<Elfo> ataqueOrdenado = new ArrayList<>();
        
        for( Elfo elfo : pelotao ){    
            if( elfo instanceof ElfoVerde && elfo.getStatus() == Status.VIVO){
                ataqueOrdenado.add(elfo);
            }
        }
        
        for( Elfo elfo : pelotao ){    
            if( elfo instanceof ElfoNoturno  && elfo.getStatus() == Status.VIVO){
                ataqueOrdenado.add(elfo);
            }
        }

        return ataqueOrdenado;
    }
    
}
