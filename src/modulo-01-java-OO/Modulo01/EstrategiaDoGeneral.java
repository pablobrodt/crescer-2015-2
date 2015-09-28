import java.util.ArrayList;

public class EstrategiaDoGeneral implements EstrategiaDeAtaque{
    
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {        
        
        ordemDoUltimoAtaque.clear();
        
        int intencaoDeAtq = pelotao.size() * dwarves.size();
        int ataquesDeElfoNoturno = (int)(intencaoDeAtq * 0.3);
        
        for (Elfo elfo : pelotao) {
            
            if( elfo.getStatus() == Status.VIVO){
            
            ordemDoUltimoAtaque.add(elfo);
            
                for (Dwarf dwarf : dwarves) {
                    if( elfo instanceof ElfoVerde || ( elfo instanceof ElfoNoturno && ataquesDeElfoNoturno > 0 ) ){
                        ataquesDeElfoNoturno = (elfo instanceof ElfoNoturno) ? ataquesDeElfoNoturno - 1 : ataquesDeElfoNoturno;
                        elfo.atirarFlecha(dwarf);
                    }else{
                        continue;
                    }
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}

