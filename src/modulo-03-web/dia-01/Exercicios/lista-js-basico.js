/*Exercicio 1
	Faça uma função chamada daisyGame que receba por argumento o número de pétalas 
	da margarida e retorne 'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, 
	mal me quer").
*/
function daisyGame( numeroPetalas ){
	var resultado = ( numeroPetalas % 2 === 0 ) ? 'Love me not' : 'Love me';
	return resultado;
}



/*Exercicio 2
	Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto 
	com maior número de caracteres.
*/
function maiorTexto( arrai ){
	var maiotTexto = arrai[0];

	for ( texto of arrai ){
		if( texto.length > maiorTexto.length ){
			maiorTexto = texto;
		}
	}

	return maiorTexto;
}


/*Exercicio 3*/

function imprime( arrai, fn ){
	if( typeof fn === 'function' ){
		for( texto of arrai ){
			fn(texto);
		}
	}else{
		console.log('Jabulani');
		console.log('TypeError: ' + typeof fn + ' is not a function.');
	}
}


