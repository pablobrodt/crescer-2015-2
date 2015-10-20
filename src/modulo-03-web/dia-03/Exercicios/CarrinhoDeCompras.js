function CarrinhoDeCompras(){
	this.itens = [];


}


CarrinhoDeCompras.prototype.adicionarItem(item){
	this.itens.push(item);
}