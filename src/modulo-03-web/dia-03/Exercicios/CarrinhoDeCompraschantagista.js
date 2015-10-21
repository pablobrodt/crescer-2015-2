CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

function CarrinhoDeComprasChantagista(){
	CarrinhoDeCompras.call(this);
}

CarrinhoDeComprasChantagista.prototype.forcarCompra = function(){
	if(!this.intervalId){
		var self = this;
		//guardar o id do intervalo
		this.intervalId = setInterval(function() {
			self.itens.forEach(function(item){
				item.valorUnitario *= 1.1;
			});
		}, 5000);
	}
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function(){
	clearInterval(this.intervalId);
	delete this.intervalId;// 'remover a propriedade intervalId do objeto
}
