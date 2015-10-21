function CarrinhoDeCompras(){
	this.itens = [];
};


CarrinhoDeCompras.prototype.adicionarItem = function(item){
	if( item instanceof Item ){
		this.itens.push(item);
	}else{
		throw new Error( 'Informe um item.');
	}
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

	return this.sortearDesconto() ? total*0.9 : total;
};

CarrinhoDeCompras.prototype.sortearDesconto = function(){
	var random = Math.floor(Math.random() * 9) + 1;
	return random > 6;
};

CarrinhoDeCompras.prototype.forcarCompra = function(){
	if(!this.intervalId){
		var _this = this;
		//guardar o id do intervalo
		this.intervalId = setInterval(function() {
			_this.itens.forEach(function(item){
				item.valorUnitario *= 1.1;
			});
		}, 5000);
	}
};

CarrinhoDeCompras.prototype.concluirPedido = function(){
	clearInterval(this.intervalId);
	delete this.intervalId;// 'remover a propriedade intervalId do objeto
}