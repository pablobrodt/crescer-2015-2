/*
Crieum bloco que tenha 2 parâmetros: Nome e UF
Esta rotina deverá verificar se já existe um registro com esta combinação(Nome e UF).
>> caso exista deverá imprimir o ID do registro;
>> caso não exista deverá criar o registro, e depoisimprimiro ID do registrogerado.
*/

CREATE PROCEDURE PRC_INSERT_CIDADE_UF(@pNome VARCHAR(100), @pUf VARCHAR(2))
AS
BEGIN
	DECLARE @vIDCidade INT,
			@vNome VARCHAR(100),
			@vUF VARCHAR(2),
			@vCount INT

			SET @vCount = 0;

	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
			FOR Select IDCidade, Nome, Uf
				From Cidade
				Group by IDCidade, Nome, Uf
				Having COUNT(1) > 0

	OPEN ListaCidade ;
	FETCH NEXT FROM ListaCidade INTO @vIDCidade, @vNome, @vUF

	WHILE(@@FETCH_STATUS=0) BEGIN
		IF (@pNome = @vNome AND @pUF = @vUF)
		BEGIN
			SET @vCount = @vCount + 1;
			PRINT CAST(@vIDCidade as VARCHAR(10));
			FETCH NEXT FROM ListaCidade INTO @vIDCidade, @vNome, @vUF
		END
		ELSE
			FETCH NEXT FROM ListaCidade INTO @vIDCidade, @vNome, @vUF
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;

	IF (@vCount=0) 
	BEGIN
		BEGIN TRANSACTION
			BEGIN TRY
				INSERT INTO Cidade (Nome, UF)
				VALUES (@pNome, @pUf)
				COMMIT
			END TRY
			BEGIN CATCH
				ROLLBACK
			END CATCH
			
			SELECT IDCidade as ID_NOVA_CIDADE
			FROM Cidade
			WHERE Nome = @pNome;
	END
END


