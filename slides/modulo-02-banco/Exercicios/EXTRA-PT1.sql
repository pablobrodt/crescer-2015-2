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
SELECT * 
FROM MATERIAL 
WHERE IDMaterial IN (
14650,
15703,
15836,
16003,
16604,
17226)