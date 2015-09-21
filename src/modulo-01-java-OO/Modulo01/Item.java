public class Item
{
    private String descricao;
    private int quantidade;
    
    /**
     * Cria um item de inventário com a quantidade e descrição informadas
     * 
     * @param quantidade Quantidade de unidades no inventário
     * @param descricao Descrição do item
     */
    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }
    
    public void aumentar1000X(){
        this.quantidade += 1000 * this.somaQtdItem();
    }
    
    public int somaQtdItem(){
        int qtdSomada = 0;
  
        for(int i=0;i<=this.quantidade;i++){
            qtdSomada += i; 
        }
        
        return qtdSomada;
    }
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}
