import java.util.HashMap;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
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
    
    public boolean equals(Object obj) {
        ExercitoDeElfos outro = (ExercitoDeElfos)obj;
        return this.exercito.equals(outro.getExercito());
    }
}
