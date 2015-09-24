import java.util.HashMap;
import java.util.ArrayList;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus;
    
    public void alistarElfo(ElfoVerde elfo){
        this.exercito.put(elfo.getNome(), elfo);
    }
    
    public void alistarElfo(ElfoNoturno elfo){
        this.exercito.put(elfo.getNome(), elfo);
    }
    
    public Elfo getElfoByNome(String nome){
        return this.exercito.get(nome);
    }
    
    public HashMap<String, Elfo> getExercito(){
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus(){
        return this.exercitoPorStatus;
    }
    
    public void agruparPorStatus(){
        exercitoPorStatus = new HashMap<>();
        for(Elfo elfo : this.exercito.values()){
            if( !exercitoPorStatus.containsKey(elfo.getStatus())){
                exercitoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            exercitoPorStatus.get(elfo.getStatus()).add(elfo);
        }
    }
    
    public boolean equals(Object obj) {
        ExercitoDeElfos outro = (ExercitoDeElfos)obj;
        return this.exercito.equals(outro.getExercito());
    }
}
