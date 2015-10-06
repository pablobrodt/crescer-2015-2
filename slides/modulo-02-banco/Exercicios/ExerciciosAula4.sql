
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


--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
SELECT E.NomeEmpregado, DE.NomeDepartamento, G.NomeEmpregado AS Gerente, DG.NomeDepartamento AS Departamento_Gerente
FROM Empregado E
INNER JOIN Empregado G ON G.IDEmpregado = E.IDGerente
INNER JOIN Departamento DE ON E.IDDepartamento = DE.IDDepartamento
INNER JOIN Departamento DG ON G.IDDepartamento = DG.IDDepartamento

--6)Faça uma cópia da tabela Empregado e altere o salário de todos os empregados 
--que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
SELECT * 
INTO EmpregadoAux
FROM Empregado

BEGIN TRANSACTION
UPDATE Empregado
SET Salario = SALARIO * 1.145
WHERE IDEmpregado IN (
					SELECT E.IDEmpregado
					FROM Empregado E
					INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento
					WHERE D.Localizacao = 'SAO PAULO'
					)

--7)Liste a diferença que representará o reajuste aplicado no item anterior 
--no somatório dos salários de todos os empregados.
SELECT SUM(E.Salario) AS SALARIO_ANTES, 
	   SUM(EA.Salario) AS SALARIO_AJUSTADO, 
	   ( SUM(E.Salario) - SUM(EA.Salario) ) AS DIFERENÇA
FROM Empregado E
INNER JOIN EmpregadoAux EA ON E.IDEmpregado = EA.IDEmpregado

--8)Liste o departamento que possui o empregado de maior salário.
SELECT D.NomeDepartamento
FROM Departamento D
LEFT JOIN Empregado E ON E.IDDepartamento = D.IDDepartamento
WHERE E.Salario = (
	SELECT MAX(Salario)
	FROM Empregado
	WHERE IDDepartamento IS NOT NULL
)

--9)Faça uma consulta para exibir o nome de cada associado e sua cidade 
--e juntamente com os empregados (nome) e a cidade (localidade) de seu 
--departamento, isto deve ser exibido em uma consulta.
SELECT A.Nome, C.Nome
FROM Associado A
LEFT JOIN Cidade C ON A.IDCidade = C.IDCidade
UNION ALL
SELECT E.NomeEmpregado, D.Localizacao
FROM Empregado E
LEFT JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento

--10)Lista as cidades que tenham associado relacionado.
SELECT C.Nome
FROM Cidade C
LEFT JOIN Associado A ON A.IDCidade = C.IDCidade
WHERE A.IDCidade IS NOT NULL
