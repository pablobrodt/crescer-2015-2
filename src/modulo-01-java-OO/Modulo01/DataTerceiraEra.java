
public class DataTerceiraEra
{
    int dia;
    int mes;
    int ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    
    public boolean ehBissexto(){
        boolean bissexto = (this.ano % 4 == 0  &&  this.ano % 100 != 0  ||  this.ano % 400 == 0);
        return bissexto;
    }
}