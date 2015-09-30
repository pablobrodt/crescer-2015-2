--Fa�a uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado).
SELECT SUBSTRING(Nome, 0, CHARINDEX(' ', Nome))
FROM Associado;

--Fa�a uma consulta que retorne o nome dos associados e a idade de cada um (em anos, exibir um n�mero inteiro).
SELECT Nome, DATEDIFF(year, DataNascimento, getdate()) as Idade
FROM Associado;

--Fa�a uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. 
--Exibir tamb�m o total de meses de trabalho at� a data de 31/12/2000.
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

--Qual o cargo (tabela empregado) possuir mais empregados?
SELECT TOP 1 COUNT(1) as Quantidade, Cargo
FROM Empregado
GROUP BY Cargo
ORDER BY COUNT(1) DESC




--Qual � o associado de maior nome (n�mero de caracteres) ?
SELECT TOP 1 Nome, LEN(Nome)
FROM Associado
ORDER BY LEN(Nome) DESC 


--Fa�a uma consulta que retorne o nome do associado e a data de quando cada completar� 
--(ou completou) 50 anos, liste tamb�m o dia da semana.
SELECT Nome, DATEADD(year, 50, DataNascimento) Aniversario50, DATENAME(weekday, DATEADD(year, 50, DataNascimento))
FROM Associado;

--Liste a quantidade de cidades agrupando por UF.
SELECT COUNT(1), UF
FROM Cidade
GROUP BY UF;

--8)Liste as cidades que possuem o mesmo nome e UF.
SELECT Nome, UF
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(Nome) > 1;

--9)Identifique qual deve ser o pr�ximo ID para a cria��o de um novo registro na tabela Associado (maior + 1).
SELECT MAX(IDAssociado) + 1
FROM Associado

--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF�s distintos, 
--considere somente o menor c�digo ID das cidades duplicadas.
--TRUNCATE TABLE CidadeAux;