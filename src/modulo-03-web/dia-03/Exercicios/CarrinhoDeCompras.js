function CarrinhoDeCompras(){
	this.itens = [];
}


CarrinhoDeCompras.prototype.adicionarItem = function(item){
	this.itens.push(item);
}

CarrinhoDeCompras.prototype.indiceDoItem = function(sku){
	return this.itens.map(function(elem){
				return elem.sku;
			}).indexOf(sku);
}

CarrinhoDeCompras.prototype.removerItem = function(sku){
	var indiceDoItem = this.indiceDoItem(sku);
	this.itens.splice(indiceDoItem, 1);
}
