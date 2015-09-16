import java.util.Random;


public class Elfo {
    private String nome;
    private int flechas = 42; //Valor default de flechas é 42 para qualquer elfo que nascer sem flechas
    private int experiencia = 10; //Experiência default para todo elfo, porque se nao tem o minimo de experiencia em arquearia, não é elfo
    private int maximoDeExperiencia = 100; //Define o numero maximo de experiência possivel de adquirir
    
    public Elfo( String nome ){ 
        
        iniciaElfo( nome, 0 );
    
    }
    
    public Elfo( String nome, int flechas ){
    
        iniciaElfo( nome, flechas );
    
    }
    
    public void iniciaElfo( String nome, int flechas ) {
        
        this.nome = nome; 
        
        if( flechas > 0 ){
        
            this.flechas = flechas; 
                                   
        }
    }
    
    
    public void atirarFlechaRefactory( int f ){ 
        
        if ( this.flechas >= f ){ 
        
            if( f <= 3 && f > 0  ){ 
        
                if(  acertar() == true){ //Executa um teste baseado na experiência deste elfo
                    
                    System.out.println("+"+ adquireExperiencia( f ) +"xp     Total: " + this.experiencia ); 
                   
                }else{
                    
                    
                    System.out.println("+"+ adquireExperiencia( 1 ) +"xp     Total: " + this.experiencia ); 
                
                }
                
                 this.flechas -= f; 
              
            }else{ 
            
                System.out.println("Serio? Atirar mais de 3 flechas juntas?");
            
            }
            
        }else{
        
            System.out.println("Você não tem tantas flechas.");
        
        }

    }
    
    private int adquireExperiencia( int xp ){ //Ação (método) que soma a experiência de acordo com as flechas lançadas
        
        int retorno = 0; 
    
        if( this.experiencia < maximoDeExperiencia ){ 
        
            this.experiencia += xp; 
            
            if( this.experiencia >= maximoDeExperiencia ){   
                
                this.experiencia = maximoDeExperiencia; 
            
            }
            
            retorno = xp;
        
        }else{
            
            System.out.println("Você já possui o máximo de experiência.");
        
        }
    
        return retorno; 
        
    }
    
    
    private boolean acertar(){ //Ação (método) que verifica se o elfo acertou onde queria
        
        boolean retorno = false;
        
        Random r = new Random(); //Instancia um objeto Random, para gerarmos um numero aleatorio
        
        if( this.experiencia <= maximoDeExperiencia ){ 
        
            if( r.nextInt(maximoDeExperiencia) <= this.experiencia ){ //gera um numero aleatorio entre 0 e o maximo de experiencia do elfo, 
                                                                      //e verifica se este número é menor ou igual à experiencia atual do mesmo
            
                retorno = true; 
                
                System.out.println("Acertou!!");
            
            }else{ 
            
                System.out.println("Errou!!");
            
            }
            
        }else{ 
        
           System.out.println("Acertou!!"); 
           retorno = true;
        
        }
        
        
        return retorno;
    
    }
    
    
}