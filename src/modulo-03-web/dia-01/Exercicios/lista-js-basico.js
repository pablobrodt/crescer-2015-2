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



/*Exercicio 5
Faça uma função excelis que receba uma string que seja uma referência válida para uma coluna Excel e retorne o valor que representa aquela coluna. Exemplos:

excelis('A'); // 1
excelis('Z'); // 26
excelis('AA'); // 27
excelis('AZ'); // 52

excelis('BA'); // 53
Dica: utilize a função charCodeAt para te ajudar!
*/
function excelis( texto ){

	var soma = 0;

		if( typeof texto === 'string' ){

			for( var i = 0; i < texto.length; i++ ){

				if( texto.charCodeAt(i) > 64 && texto.charCodeAt(i) < 91 ){			

					soma += (texto.charCodeAt(i)-64) * Math.pow(26, texto.length-i-1);
				}
			}
		}else{
			console.log(typeof texto + ' não é texto.')
		}

	return soma;
}
