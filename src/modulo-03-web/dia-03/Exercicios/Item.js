function Item(sku, descricao, quantidade, valorUnitario){
	if( isString(sku) && isString(descricao) && isNumber(quantidade) && isNumber(valorUnitario) ){
		this.sku = sku;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}else{
		throw new Error('Parâmetros inválidos.');
	}
};


Item.prototype.subTotal = function(){
	return this.quantidade * this.valorUnitario;
};