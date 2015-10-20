var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
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


  function ordenar( clubes, titulo ){

    clubes.sort(function(clube1, clube2){

      return qtdTitulos(titulo, clube1) < qtdTitulos(titulo, clube2);

    });

    return clubes;

  };


  function somarTitulos( clubes, titulo ){

   return clubes.reduce(function(acumulador, clubeAtual){

      return acumulador + qtdTitulos( titulo, clubeAtual );

    }, 0);
  }



/*
 *Exercicio 1
 */

 /*1.A
  *Crie uma função chamada ordenaPorNacionais(Array) que recebe 
  *o array de clubes e retorna o array ordenado pela quantidade de 
  *títulos Nacionais descendente (Z->A).
  */

  function ordenaPorNacionais( clubes ){

    return ordenar( clubes, 'Nacionais');

  };

/* 1.B
 *Crie uma função chamada ordenaPorContinentais(Array) que recebe o 
 * array de clubes e retorna o array ordenado pela quantidade de títulos 
 *Continentais descendente (Z->A).
*/

  function ordenaPorContinentais( clubes ){

    return ordenar( clubes, 'Continentais');

  };


/* 1.C
 *Crie uma função chamada ordenaPorMundiais(Array) que recebe o array 
 *de clubes e retorna o array ordenado pela quantidade de títulos Mundiais 
 *descendente (Z->A).
 */

   function ordenaPorMundiais( clubes ){

    return ordenar( clubes, 'Mundiais');

  };


//Exercicio 2
/*2.A
 *Crie uma função chamada somarPorNacionais(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de 
 *títulos nacionais entre os clubes do array.
 */

 function somarPorNacionais( clubes ){

  return somarTitulos(clubes, 'Nacionais');

 };


/*2.B
 *Crie uma função chamada somarPorContinentais(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de 
 *títulos continentais entre os clubes do array.
 */

 function somarPorContinentais( clubes ){

    return somarTitulos(clubes, 'Continentais');

 };


/*2.C
 *Crie uma função chamada somarPorTodosTitulos(Array) que recebe o 
 *array de clubes e retorna o somatório de todas quantidades de todos 
 *os títulos entre os clubes do array.
 */

  function somarPorTodosTitulos( clubes ){

    return somarTitulos(clubes, 'Todos');

 };



 //Exercicio 3

 function apenasOsMelhores( clubes ){

  return clubes.filter(function(elem){

    return qtdTitulos('Nacionais', elem) > 18;

  });

 }


//exercicio 4

function calcularIdadeMedia( clubes ){

    var soma = clubes.reduce(function(acumulador, clube){

      return acumulador + (new Date().getFullYear() - clube.fundacao.getFullYear());

    }, 0);

    return soma / 4;

}