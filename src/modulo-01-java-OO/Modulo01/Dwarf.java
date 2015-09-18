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
    /*
    Se o campo dataNascimento do objeto Dwarf for bissexto 
    e a vida do Dwarf estiver entre 80 e 90 (incluindo 80 e 90), 
    multiplique o número a ser retornado por -33   
    */
    public double getNumeroSorte(){
        double sorte = 101.0;
        boolean vidaDeSorte = this.vida >= 80 && this.vida <=90;
        boolean nomeDeSorte = this.nome.equals("Seixas") || this.nome.equals("Meireles");
       
        
        if( this.dataNascimento.ehBissexto() && vidaDeSorte ){
            sorte = sorte * -33;
        }else if( !this.dataNascimento.ehBissexto() && nomeDeSorte ){
            sorte = sorte * 33;
            sorte = sorte%100;
        }
        
        return sorte;
    }
}
