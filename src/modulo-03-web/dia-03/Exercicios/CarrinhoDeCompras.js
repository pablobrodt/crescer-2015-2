function CarrinhoDeCompras(){
	this.itens = [];
};


CarrinhoDeCompras.prototype.adicionarItem = function(item){
	if( item instanceof Item )
		this.itens.push(item);
};

CarrinhoDeCompras.prototype.indiceDoItem = function(sku){
	return this.itens.map(function(elem){
				return elem.sku;
			}).indexOf(sku);
};

CarrinhoDeCompras.prototype.removerItem = function(sku){
	this.itens.splice(this.indiceDoItem(sku), 1);
};


CarrinhoDeCompras.prototype.atualizarQuantidade = function( sku, quantidade ){
	this.itens[this.indiceDoItem(sku)].quantidade = quantidade;
};

CarrinhoDeCompras.prototype.calcularTotal = function(){
	var total = this.itens.reduce(function(acumulador, item){
		return acumulador + item.subTotal();
	}, 0);

	return this.sortearDesconto() ? total-(total*0.1) : total;
};

CarrinhoDeCompras.prototype.sortearDesconto = function(){
	var random = Math.floor(Math.random() * 9) + 1;
	return random > 6;
};