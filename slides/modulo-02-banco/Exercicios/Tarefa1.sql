
select * from governador

BEGIN TRANSACTION
CREATE TABLE Governador(
	IDGovernador INT IDENTITY NOT NULL,
	Nome VARCHAR(200) NOT NULL,
	CidadeNatal VARCHAR(200) NOT NULL,
	DataNascimento DATETIME NOT NULL,
	InicioMandato DATETIME NOT NULL,
	FimMandato DATETIME NOT NULL,
		CONSTRAINT PK_Governador PRIMARY KEY (IDGovernador)
)
commit

BEGIN TRANSACTION
INSERT INTO Governador
(
	Nome,
	CidadeNatal,
	DataNascimento, 
	InicioMandato, 
	FimMandato
)
VALUES
(
	'João de Deus Mena Barreto',
	'Rio Pardo',
	CONVERT(DATETIME, '02/07/1769', 103),
	CONVERT(DATETIME, '29/08/1822', 103),
	CONVERT(DATETIME, '29/11/1823', 103)
)

rollback

commit

BEGIN TRANSACTION
INSERT INTO Governador
(
	Nome,
	CidadeNatal,
	DataNascimento, 
	InicioMandato, 
	FimMandato
)
VALUES
(
	'João Carlos Gregório Domingos Vicente Francisco de Saldanha Oliveira e Daun',
	'Lisboa',
	CONVERT(DATETIME, '17/11/1790', 103),
	CONVERT(DATETIME, '22/02/1822', 103),
	CONVERT(DATETIME, '19/08/1790', 103)
)

rollback


BEGIN TRANSACTION
INSERT INTO Governador
(
	Nome,
	CidadeNatal,
	DataNascimento, 
	InicioMandato, 
	FimMandato
)
VALUES
(
	'José Inácio da Silva',
	'Desconhecido',
	NULL,
	CONVERT(DATETIME, '29/11/1823', 103),
	CONVERT(DATETIME, '08/03/1824', 103)
)



BEGIN TRANSACTION
INSERT INTO Governador
(
	Nome,
	CidadeNatal,
	DataNascimento, 
	InicioMandato, 
	FimMandato
)
VALUES
(
	'José Feliciano Fernandes Pinheiro',
	'Santos',
	CONVERT(DATETIME, '09/05/1774', 103),
	CONVERT(DATETIME, '08/03/1824', 103),
	CONVERT(DATETIME, '14/01/1826', 103)
)

commit




BEGIN TRANSACTION
INSERT INTO Governador
(
	Nome,
	CidadeNatal,
	DataNascimento, 
	InicioMandato, 
	FimMandato
)
VALUES
(
	'José Egídio Gordilho de Barbuda',
	'Chamusca',
	CONVERT(DATETIME, '01/08/1787', 103),
	CONVERT(DATETIME, '14/01/1826', 103),
	CONVERT(DATETIME, '04/11/1826', 103)
)

