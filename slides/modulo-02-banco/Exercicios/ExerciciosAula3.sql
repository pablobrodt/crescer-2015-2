--1)Faça uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado).
SELECT SUBSTRING(Nome, 0, CHARINDEX(' ', Nome))
FROM Associado;

--2)Faça uma consulta que retorne o nome dos associados e a idade de cada um (em anos, exibir um número inteiro).
SELECT Nome, DATEDIFF(year, DataNascimento, getdate()) as Idade
FROM Associado;

--3)Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. 
--Exibir também o total de meses de trabalho até a data de 31/12/2000.
SELECT 
	IDEmpregado, 
	NomeEmpregado, 
	Cargo, 
	IDGerente, 
	DataAdmissao, 
	Salario, 
	Comissao, 
	IDDepartamento, 
	DATEDIFF(month, DataAdmissao, '2000/12/31') as QtdMesesTrabalhados
FROM Empregado
WHERE DataAdmissao BETWEEN '1980/05/01' AND '1982/12/31';

--4)Qual o cargo (tabela empregado) possuir mais empregados?
SELECT TOP 1 COUNT(1) as Quantidade, Cargo
FROM Empregado
GROUP BY Cargo
ORDER BY COUNT(1) DESC




--5)Qual é o associado de maior nome (número de caracteres) ?
SELECT TOP 1 Nome, LEN(Nome)
FROM Associado
ORDER BY LEN(Nome) DESC 


--6)Faça uma consulta que retorne o nome do associado e a data de quando cada completará 
--(ou completou) 50 anos, liste também o dia da semana.
SELECT Nome, DATEADD(year, 50, DataNascimento) Aniversario50, DATENAME(weekday, DATEADD(year, 50, DataNascimento))
FROM Associado;

--7)Liste a quantidade de cidades agrupando por UF.
SELECT COUNT(1), UF
FROM Cidade
GROUP BY UF;

--8)Liste as cidades que possuem o mesmo nome e UF.
SELECT Nome, UF
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(Nome) > 1;

--9)Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado (maior + 1).
SELECT ISNULL( MAX(IDAssociado), 0) + 1
FROM Associado

--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF’s distintos, 
--considere somente o menor código ID das cidades duplicadas.
--TRUNCATE TABLE CidadeAux;
INSERT INTO CidadeAux(IDCidade, Nome, UF)
	SELECT MIN(IDCidade) IDCidade, Nome, UF
	FROM Cidade
	GROUP BY Nome, UF
	ORDER BY IDCidade


--11)Altere todas cidades duplicadas (nome e uf iguais), acrescente no ínicio do nome um asterisco (*).
BEGIN TRANSACTION
UPDATE Cidade
SET Nome = '*' + Nome
WHERE Nome IN(
	SELECT Nome
	FROM Cidade
	GROUP BY Nome, UF
	HAVING COUNT(Nome)>1
)




--12)Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, 
--informando: Masculino ou Feminino.
SELECT Nome,
	CASE
		WHEN sexo = 'F' THEN 'Feminino'
		WHEN sexo = 'M' THEN 'Masculino'
	END AS Genero
FROM Associado


--13)Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser 
--descontado do Imposto de Renda, considerando a tabela abaixo:
--Até R$ 1.164,00 = 0%De R$ 1.164,00 a R$ 2.326,00 = 15%
--Acima de R$ 2.326,00 = 27,5%.

SELECT e.NomeEmpregado, e.Salario,
								CASE
									WHEN e.Salario <= 1164 THEN '0%'
									WHEN e.Salario > 1164 AND e.Salario <= 2326 THEN '15%'
									WHEN e.Salario > 2326 THEN '27,5%'
								END Imposto_Renda
FROM Empregado e

--14)Elimine as cidades duplicadas (mantendo 1 registro para cada).
begin transaction
DELETE FROM Cidade
WHERE IDCidade IN (
	SELECT max(IDCidade)
	FROM Cidade
	GROUP BY Nome
	HAVING COUNT(Nome) >1
)


--15)Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.
begin transaction

ALTER TABLE Cidade
	ADD CONSTRAINT UK_Cidade_UF UNIQUE (Nome, UF)
