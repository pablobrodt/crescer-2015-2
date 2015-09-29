select * from Empregado;

--Fa�a uma consulta (query) que retorne o nome dos empregados exibindo em ordem de admiss�o.
SELECT NomeEmpregado
FROM Empregado
ORDER BY DataAdmissao;

--Fa�a uma consulta que retorne o nome dos empregados e o sal�rio anual, onde o cargo seja 
--Atendente ou que o sal�rio anual seja inferior a R$ 18.500,00.
SELECT NomeEmpregado, (Salario*12) as SalarioAnual
FROM Empregado
WHERE Cargo = 'Atendente' OR
	  Salario < 18500.00/12 AND Salario is not null;

select * from Cidade

--Retornar o ID da cidade de Uberl�ndia.
SELECT IDCidade
FROM Cidade
WHERE Nome = 'Uberl�ndia';

--Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul.
SELECT IDCidade, Nome
FROM Cidade
WHERE UF = 'RS';

