--1)Liste o total de pedidos realizados no m�s de setembro de 2015.
SELECT COUNT(1)
FROM Pedido
WHERE DataPedido BETWEEN CONVERT(datetime, '01/09/2015', 103) AND CONVERT(datetime, '30/09/2015', 103);

--2)Liste todos os clientes que tenham o LTDA no nome ou razao social.
SELECT *
FROM Cliente
WHERE Nome LIKE '%LTDA%' OR RazaoSocial LIKE '%LTDA%';


--3)Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--Nome: Galocha Maragato
--Pre�o de custo: 35.67
--Pre�o de venda: 77.95
--Situa��o: A
BEGIN TRANSACTION
INSERT INTO Produto( Nome, PrecoCusto, PrecoVenda, Situacao)
VALUES ('Galocha Maragato', 35.67, 77.95, 'A')

--4)Identifique e liste os produtos que n�o tiveram nenhum pedido, 
--considere os relacionamentos no modelo de dados, pois n�o h� relacionamento 
--direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente dever� ser listado (apenas este)
SELECT *
FROM Produto 
WHERE NOT EXISTS(
		SELECT 1
		FROM PedidoItem 
		WHERE PedidoItem.IDProduto = Produto.IDProduto 
)

--5)Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior 
--n�mero de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o 
--menor n�mero de clientes.
--Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.
SELECT TOP 1 c.UF, COUNT(DISTINCT cl.Nome) AS QTD
FROM Cidade c
LEFT JOIN Cliente cl ON cl.IDCidade = c.IDCidade
GROUP BY c.UF
ORDER BY QTD DESC

--6)Liste os pedidos com produtos que precisam destes materiais, considere somente os pedidos 
--que ser�o entregues em outubro de 2015.
--i. Campos que devem ser exibidos: IDPedido, DataEntrega, ValorPedido, Quantidade de itens
--c. Liste tamb�m os clientes destes pedidos, pois estes ser�o notificados pela �rea respons�vel.
SELECT * 
FROM MATERIAL 
WHERE IDMaterial IN (
14650,
15703,
15836,
16003,
16604,
17226)