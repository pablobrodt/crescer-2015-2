public class Dwarf {
    private int vida = 110;
    private Status status = Status.VIVO;
    private String nome;
    private int experiencia = 0;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf( String nome ){
        this( nome, new DataTerceiraEra(1,1,1) );
    }
    
    public Dwarf( String nome, DataTerceiraEra dataNascimento ){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void receberFlechada() {
        if( this.vida > 0 ){
            this.vida -= 10;
        }
        if( this.vida ==  0){
            this.status = Status.MORTO;
        }
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
}
