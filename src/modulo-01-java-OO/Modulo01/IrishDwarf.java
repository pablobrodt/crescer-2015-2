

public class IrishDwarf extends Dwarf
{   
    public IrishDwarf(){
        super();        
    }
    
    public IrishDwarf(String nome) {
        this();
        this.nome = nome;
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }
        
    
    public void tentarSorte() {
        double numero = gerarNumero();
       
        if (numero == -3333.0) {
            this.inventario.aumenta1000XEmCadaItem();
        }
    }
}
