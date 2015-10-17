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


/*Exercicio 4
	Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados.
*/
function fiboSum( numero ){

	var vlrNr1 = 0;
	var vlrNr2 = 1;
	var vlrNovo;
	var vlrTotal = 1;

	for(var i=2; i<=numero; i++)
	{	

	   vlrNovo = (vlrNr1 + vlrNr2);

	   vlrNr1 = vlrNr2;

	   vlrNr2 = vlrNovo;

	   vlrTotal += vlrNovo;
	}

	return vlrTotal;
}

