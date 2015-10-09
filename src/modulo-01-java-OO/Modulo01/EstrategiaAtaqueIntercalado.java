import java.util.ArrayList;
public class EstrategiaAtaqueIntercalado implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    private ArrayList<Elfo> atacantes = new ArrayList<Elfo>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
        if( verificarPelotao( pelotao ) ){
            
            while(ordemDoUltimoAtaque.size() != pelotao.size()){
            
                for( Elfo elfo : pelotao){
                    if(elfo.getStatus() == Status.VIVO){
                        if(!ordemDoUltimoAtaque.contains(elfo)){
                            if(ordemDoUltimoAtaque.isEmpty()){
                                ordemDoUltimoAtaque.add(elfo);
                                for( Dwarf dwarf : dwarves ){
                                    elfo.atirarFlecha(dwarf);
                                }
                            }else
                            if(ordemDoUltimoAtaque.get(ordemDoUltimoAtaque.size()-1) instanceof ElfoVerde && elfo instanceof ElfoVerde){
                                continue;
                            }else
                            if(ordemDoUltimoAtaque.get(ordemDoUltimoAtaque.size()-1) instanceof ElfoNoturno && elfo instanceof ElfoNoturno){
                                continue;
                            }else{
                            
                                ordemDoUltimoAtaque.add(elfo);
                                for( Dwarf dwarf : dwarves ){
                                elfo.atirarFlecha(dwarf);
                                }
                            }
                        }
                    }
                }
            }
            
            /*organizarAtaque( pelotao );
             * for( Elfo elfo : atacantes ){
                
                ordemDoUltimoAtaque.add(elfo);
                
                for( Dwarf dwarf : dwarves ){
                    elfo.atirarFlecha( dwarf );
                }
            }*/
        }
    }
    
    private boolean verificarPelotao( ArrayList<Elfo> pelotao ){
        int elfosVerdes = 0;
        int elfosNoturnos = 0;
        boolean aprovado = false;
        
        for ( Elfo elfo : pelotao ){
            if( elfo instanceof ElfoVerde ){
                elfosVerdes++;
            }
            if(elfo instanceof ElfoNoturno){
                elfosNoturnos++;
            }
        }
         
        if( elfosVerdes == elfosNoturnos){
            aprovado = true;
        }
        
        return aprovado;
    }
    
   /* private void organizarAtaque( ArrayList<Elfo> pelotao ){
        private ArrayList<Elfo> verdes = new ArrayList<Elfo>();
        private ArrayList<Elfo> noturnos = new ArrayList<Elfo>();
        
        for( Elfo elfo : pelotao ){
            if( elfo.getStatus() == Status.VIVO ){
               if( elfo instanceof ElfoVerde ){
                   verdes.add(elfo);
               }
               if( elfo instanceof ElfoNoturno ){
                   verdes.add(elfo);
               }
            }
        }
        
        
    }
    
    
       if( atacantes.isEmpty() ){
                    atacantes.add(elfo);
                }else{
                    if( atacantes.get( atacantes.size()-1 ) instanceof ElfoVerde && elfo instanceof ElfoNoturno ){
                        atacantes.add(elfo);
                    }else 
                    if( atacantes.get( atacantes.size()-1 ) instanceof ElfoNoturno && elfo instanceof ElfoVerde ){
                        atacantes.add(elfo);
                    }
                }
       */
}   
