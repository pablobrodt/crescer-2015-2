var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];




/*
 * FUNÇÕES NO MACROCOSMO
 */

  function qtdTitulos( titulo, clube ){
    
    var qtd = 0;

    clube.titulos.forEach(function(t){

      if( t.desc === titulo || titulo === 'Todos'){

        qtd = t.qtd;

      };

    });

    return qtd;

  };


/*
 *Exercicio 1
 */

 /*1.A
  *Crie uma função chamada ordenaPorNacionais(Array) que recebe 
  *o array de clubes e retorna o array ordenado pela quantidade de 
  *títulos Nacionais descendente (Z->A).
  */

  function ordenaPorNacionais( clubes ){

    clubes.sort(function(clube1, clube2){

      return qtdTitulos('Nacionais', clube1) < qtdTitulos('Nacionais', clube2);

    });

  };

/* 1.B
 *Crie uma função chamada ordenaPorContinentais(Array) que recebe o 
 * array de clubes e retorna o array ordenado pela quantidade de títulos 
 *Continentais descendente (Z->A).
*/

  function ordenaPorContinentais( clubes ){

    clubes.sort(function(clube1, clube2){

      return qtdTitulos('Continentais', clube1) < qtdTitulos('Continentais', clube2);

    });

  };


/* 1.C
 *Crie uma função chamada ordenaPorMundiais(Array) que recebe o array 
 *de clubes e retorna o array ordenado pela quantidade de títulos Mundiais 
 *descendente (Z->A).
 */

   function ordenaPorMundiais( clubes ){

    clubes.sort(function(clube1, clube2){

      return qtdTitulos('Mundiais', clube1) < qtdTitulos('Mundiais', clube2);

    });

  };


//Exercicio 2
/*2.A
 *Crie uma função chamada somarPorNacionais(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de 
 *títulos nacionais entre os clubes do array.
 */

 function somarPorNacionais( clubes ){

    var soma = 0;

    clubes.forEach(function(clube){

        soma += qtdTitulos('Nacionais', clube);

    });

    return soma;

 };


/*2.B
 *Crie uma função chamada somarPorContinentais(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de 
 *títulos continentais entre os clubes do array.
 */

 function somarPorContinentais( clubes ){

    var soma = 0;

    clubes.forEach(function(clube){

        soma += qtdTitulos('Continentais', clube);

    });

    return soma;

 };


/*2.C
 *Crie uma função chamada somarPorTodosTitulos(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de todos 
 *os títulos entre os clubes do array.
 */

  function somarPorTodosTitulos( clubes ){

    var soma = 0;

    clubes.forEach(function(clube){

      soma += qtdTitulos('Todos', clube);

    });

    return soma;

 };



 //Exercicio 3

 function apenasOsMelhores( clubes ){

  var melhor;

  clubes.forEach(function(clube){

      if( qtdTitulos('Nacionais', clube) > 18 ){

        melhor = clube;

      }

    });

   return melhor;

 }
