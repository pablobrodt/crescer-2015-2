String.prototype.palindromo = function(){
	return this.split('').join('') === this.split('').reverse().join('');
}