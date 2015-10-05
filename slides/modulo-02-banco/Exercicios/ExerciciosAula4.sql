
--1)Selecione o nome do empregado e nome do departamento que cada um está associado.
SELECT e.NomeEmpregado, d.NomeDepartamento
FROM Empregado e
 INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento;

 --2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
 SELECT a.Nome, c.Nome
 FROM Associado a
 LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade;


 --3)Lista os estados (UF) e total de cidades que não possuem associados relacionados 
 --(dica: pode ser utilizado count + group by + exists)
Select c.uf, COUNT( DISTINCT c.Nome) AS Cidades_Sem_Associado
From Cidade c
LEFT JOIN  Associado a ON a.IDCidade = c.IDCidade
WHERE a.IDAssociado IS NULL
GROUP BY c.UF

--4)Faça uma consulta que liste o nome do associado, o nome da cidade, 
--e uma coluna que indique se a cidade é da região SUL (RS, SC, PR), 
--se for imprimir *** (3 asteriscos), senão imprimir nulo.

SELECT a.Nome Associado, c.Nome Cidade, 
					CASE
						WHEN c.UF = 'RS' OR c.UF = 'SC' OR c.UF = 'PR'
						THEN '***'
						ELSE NULL
					END Regiao_Sul
FROM Associado a
LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade
	
