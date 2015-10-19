/*
* CWI Software
*/
// Exercício 01

function isNumber(number) {
  return typeof number === 'number';
  // return !isNaN(number);
};

function isFunction(fn) {
  return typeof fn === 'function';
};

function daisyGame(petals) { console.log('inline'); };

var daisyGame = function(petals) { 
  if (isNumber(petals)) {
    return 'Love me' + ( petals % 2 === 0 ? ' not' : '' );
  } else {
    throw new Error('Petals not a number!');
  }
};

var arr = ['t1', 'maior t3xt0', 't2a', 'u', '123'];
arr['nome'] = 'Array querido';

for (var prop in arr) {
  console.log(arr[prop]);
}

(function maiorTexto(textos) {

  for (var i = 0, maiorTxt = '', len = textos.length; i < len; i++) {
    (function() {
      var dentro = 'fora';
      if (textos[i].length > maiorTxt.length) {
        maiorTxt = textos[i];
      }
      //console.log(textos[i]);
    })();
  }

  //console.log('fora: %o', dentro);

  return maiorTxt;
})(arr);

function imprime(instrutores, fn) {
  // debugger;
  if (isFunction(fn)) {
    instrutores.forEach(fn);  
  }
};

var imprimeInstrutor = function(instrutor) {
  console.log(instrutor);
};

var alerta = function(instrutor) {
  alert(instrutor);
};

imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor);
imprime(['bernardo', 'nunes', 'benhur'], 'oi');
// ERRADO:
// imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor());

var fibonacci = function(n) {
  if (n === 1) return 1;
  if (n === 2) return 1;

  return fibonacci(n-1)+fibonacci(n-2);
};

// fiboSum(7) => 13+8+5+3+2+1+1

var fiboSum = function(n) {
  //if (n === 1) return 1;
  //return fibonacci(n) + fiboSum(n-1);
  return fibonacci(n+2)-1;
};