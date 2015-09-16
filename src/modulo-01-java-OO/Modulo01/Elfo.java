import java.util.Random;


public class Elfo {
    private String nome;
    private int flechas = 42; //Valor default de flechas é 42 para qualquer elfo que nascer sem flechas
    private int experiencia = 10; //Experiência default para todo elfo, porque se nao tem o minimo de experiencia em arquearia, não é elfo
    private int maximoDeExperiencia = 100; //Define o numero maximo de experiência possivel de adquirir
    
    public Elfo( String nome ){ //Construtor pedindo somente o nome do elfo
        
        iniciaElfo( nome, 0 );
    
    }
    
    public Elfo( String nome, int flechas ){
    
        iniciaElfo( nome, flechas );
    
    }
    
    public void iniciaElfo( String nome, int flechas ) { //construtor pedindo o nome e a quantidade de flechas deste elfo
        
        this.nome = nome; //Atribui o nome à variavel 'nome' deste elfo
        
        if( flechas > 0 ){//Se o numero de flechas informadas for maior que zero
        
            this.flechas = flechas; //Atribui a quantidade de flechas à variavel 'flechas' deste elfo
                                    //Caso contrario continua valendo o default
        }
    }
    
    
    public void atirarFlechaRefactory( int f ){ //Ação (método) de atirar flechas, deste elfo
        
        if ( this.flechas >= f ){ //Verifica se a quantidade de flechas que o elfo tem é maior do que a quantidade que deseja atirar
        
            if( f <= 3 && f > 0  ){ //Limita o número de flechas no maximo 3, porque ate elfos tem limites
        
                if(  acertar() == true){ //Executa um teste baseado na experiência deste elfo
                    
                    System.out.println("+"+ adquireExperiencia( f ) +"xp     Total: " + this.experiencia ); //Se acertou, adquire a experiência referente`ao numero de flechas lançadas 
                   
                }else{
                    
                    
                    System.out.println("+"+ adquireExperiencia( 1 ) +"xp     Total: " + this.experiencia ); //Se errou, adquire somente 1 ponto de experiência
                
                }
                
                 this.flechas -= f; //Reduz o número de flechas que o elfo possui, de acordo com as flechas lançadas
              
            }else{ //Caso tente atirar mais de 3 flechas juntas tempo...
            
                System.out.println("Serio? Atirar mais de 3 flechas juntas?");
            
            }
            
        }else{ //Caso você não tenha tantas flechas quanto queira atirar
        
            System.out.println("Você não tem tantas flechas.");
        
        }

    }
    
    private int adquireExperiencia( int xp ){ //Ação (método) que soma a experiência de acordo com as flechas lançadas
        
        int retorno = 0; 
    
        if( this.experiencia < maximoDeExperiencia ){ //Este teste restringe a experiência ao maximo definido na classe
        
            this.experiencia += xp; //Soma a experiencia total à experiencia adquirida
            
            if( this.experiencia >= maximoDeExperiencia ){ //Verifica se a experiencia atual, apos a soma, é maior ou igual ao meu maximoDeExperiencia     
                
                this.experiencia = maximoDeExperiencia; //Caso verdadeiro, minha experiencia recebe o maximo possivel
            
            }
            
            retorno = xp; //Atribui a quantidade de experiência obtida à variável de retorno
        
        }else{ //Caso a experiência já seja 100 pontos
            
            System.out.println("Você já possui o máximo de experiência.");
        
        }
    
        return retorno; //Retorna o valor para que o algoritmo acima posso exibir na tela
        
    }
    
    
    private boolean acertar(){ //Ação (método) que verifica se o elfo acertou onde queria
        
        boolean retorno = false;
        
        Random r = new Random(); //Instancia um objeto Random, para gerarmos um numero aleatorio
        
        if( this.experiencia <= maximoDeExperiencia ){ //verifica se minha experiencia ja esta no maximo
        
            if( r.nextInt(maximoDeExperiencia) <= this.experiencia ){ //gera um numero aleatorio entre 0 e o maximo de experiencia do elfo, 
                                                                      //e verifica se este número é menor ou igual à experiencia atual do mesmo
            
                retorno = true; //Se o numero gerado foi menor ou igual então acertou
                
                System.out.println("Acertou!!");
            
            }else{ //caso contrario, o elfo errou
            
                System.out.println("Errou!!");
            
            }
            
        }else{ //caso minha experiencia já esteja no seu maximo, o elfo vai acertar sempre, porque ele é foda
        
           System.out.println("Acertou!!"); 
           retorno = true;
        
        }
        
        
        return retorno;
    
    }
    
    
}