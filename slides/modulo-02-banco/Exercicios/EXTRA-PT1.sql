--1)Liste o total de pedidos realizados no mês de setembro de 2015.
SELECT COUNT(1)
FROM Pedido
WHERE DataPedido BETWEEN CONVERT(datetime, '01/09/2015', 103) AND CONVERT(datetime, '30/09/2015', 103);

--2)Liste todos os clientes que tenham o LTDA no nome ou razao social.
SELECT *
FROM Cliente
WHERE Nome LIKE '%LTDA%' OR RazaoSocial LIKE '%LTDA%';


--3)Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
--Nome: Galocha Maragato
--Preço de custo: 35.67
--Preço de venda: 77.95
--Situação: A
BEGIN TRANSACTION
INSERT INTO Produto( Nome, PrecoCusto, PrecoVenda, Situacao)
VALUES ('Galocha Maragato', 35.67, 77.95, 'A')

--4)Identifique e liste os produtos que não tiveram nenhum pedido, 
--considere os relacionamentos no modelo de dados, pois não há relacionamento 
--direto entre Produto e Pedido (será preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente deverá ser listado (apenas este)
SELECT *
FROM Produto 
WHERE NOT EXISTS(
		SELECT 1
		FROM PedidoItem 
		WHERE PedidoItem.IDProduto = Produto.IDProduto 
)

--5)Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior 
--número de clientes (tabela Cliente), liste também qual o Estado possuí o 
--menor número de clientes.
--Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.
SELECT TOP 1 c.UF, COUNT(DISTINCT cl.Nome) AS QTD
FROM Cidade c
LEFT JOIN Cliente cl ON cl.IDCidade = c.IDCidade
GROUP BY c.UF
ORDER BY QTD DESC

--6)Liste os pedidos com produtos que precisam destes materiais, considere somente os pedidos 
--que serão entregues em outubro de 2015.
--i. Campos que devem ser exibidos: IDPedido, DataEntrega, ValorPedido, Quantidade de itens
--c. Liste também os clientes destes pedidos, pois estes serão notificados pela área responsável.
SELECT PD.IDPedido, PD.DataEntrega, PD.ValorPedido, C.*
FROM Pedido PD
INNER JOIN PedidoItem PIT ON PD.IDPedido = PIT.IDPedido
LEFT JOIN Cliente C ON C.IDCliente = PD.IDCliente
WHERE PD.DataEntrega BETWEEN CONVERT(DATETIME,'01/10/2015', 103) AND CONVERT(DATETIME, '31/10/2015', 103)
AND PIT.IDProduto IN (
						SELECT P.IDProduto FROM Produto P
						INNER JOIN ProdutoMaterial PM ON P.IDProduto = PM.IDProduto 
						WHERE PM.IDMaterial IN (
												14650,
												15703,
												15836,
												16003,
				 								16604,
												17226
												)
					)
ORDER BY PD.DataEntrega

--7)Liste quais os produtos que utilizam o material de IDMaterial = 15836.
SELECT PD.*
FROM Produto PD
INNER JOIN ProdutoMaterial PM ON PD.IDProduto = PM.IDProduto
WHERE PM.IDMaterial = 15836


--8)Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais 
--(tabela ProdutoMaterial). Identifique se existe algum produto sem material relacionado.
--Obs.: o produto criado anteriormente deverá ser listado.
SELECT PD.*
FROM Produto PD
LEFT JOIN ProdutoMaterial PM ON PM.IDProduto = PD.IDProduto
WHERE PM.IDMaterial IS NULL


--9)Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT top 1 PN.Nome, COUNT(PN.Nome) AS Repetidos
FROM (
		SELECT SUBSTRING(C.Nome, 0, CHARINDEX(' ', Nome)) AS Nome
		FROM Cliente C
		) AS PN
GROUP BY PN.Nome
ORDER BY Repetidos DESC
			