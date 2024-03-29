	CREATE TABLE PAIS (
	  ID_PAIS NUMERIC(38,0) NOT NULL,
	  NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_PAIS)
	);
  
	CREATE TABLE ESTADO (
	  ID_ESTADO NUMERIC(38,0) NOT NULL,
	  ID_PAIS NUMERIC(38,0) NOT NULL,
	  NOME VARCHAR2(50) NOT NULL, 
	PRIMARY KEY (ID_ESTADO),
	
	CONSTRAINT fk_ID_PAIS 
	FOREIGN KEY (ID_PAIS)
	REFERENCES PAIS (ID_PAIS)
	);
	    
	CREATE TABLE CIDADE (
		  ID_CIDADE NUMERIC(38,0) NOT NULL,
		  NOME VARCHAR2(50) NOT NULL,
		  ID_ESTADO NUMERIC(38,0) NOT NULL,
	PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	  
	CONSTRAINT fk_ID_ESTADO  
	FOREIGN KEY (ID_ESTADO)
	REFERENCES ESTADO (ID_ESTADO)
	);
	    
	CREATE TABLE BAIRRO (
		  ID_BAIRRO NUMERIC(38,0) NOT NULL,
		  ID_ESTADO NUMERIC(38,0) NOT NULL,
		  NOME VARCHAR2(250) NOT NULL,
		  ID_CIDADE NUMERIC(38,0) NOT NULL,
	PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	  
	CONSTRAINT fk_ID_CIDADE  
	FOREIGN KEY (ID_CIDADE, ID_ESTADO)
	REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
	);
	    
	CREATE TABLE ENDERECO (
		  ID_ENDERECO NUMERIC(38,0) NOT NULL,
		  ID_CIDADE NUMERIC(38,0) NOT NULL,
		  LOGRADOURO VARCHAR2(255) NOT NULL,
		  NUMERO NUMERIC(38,0) NOT NULL,
		  COMPLEMENTO VARCHAR2(100) NOT NULL,
		  CEP VARCHAR2(9) NOT NULL,
		  ID_BAIRRO NUMERIC(38,0) NOT NULL,
	PRIMARY KEY (ID_ENDERECO), 
	  
	CONSTRAINT fk_ID_BAIRRO  
	FOREIGN KEY (ID_BAIRRO, ID_CIDADE)
	REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
	);	

	CREATE SEQUENCE SEQ_PAIS
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

	CREATE SEQUENCE SEQ_ESTADO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

	CREATE SEQUENCE SEQ_CIDADE
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

	CREATE SEQUENCE SEQ_BAIRRO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

	CREATE SEQUENCE SEQ_ENDERECO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

----------------------------------------------------PA�S
	INSERT INTO PAIS (ID_PAIS, NOME)
	VALUES (SEQ_PAIS.nextval,'Brasil');

	INSERT INTO PAIS (ID_PAIS, NOME)
	VALUES (SEQ_PAIS.nextval,'Estados Unidos');
----------------------------------------------------ESTADOS
	INSERT INTO ESTADO (ID_ESTADO, NOME, ID_PAIS)
	VALUES (SEQ_ESTADO.nextval, 'S�o Paulo', 1);

	INSERT INTO ESTADO (ID_ESTADO, NOME, ID_PAIS)
	VALUES (SEQ_ESTADO.nextval, 'Rio Grande do Sul', 1);

	INSERT INTO ESTADO (ID_ESTADO, NOME, ID_PAIS)
	VALUES (SEQ_ESTADO.nextval,'New York', 2);

	INSERT INTO ESTADO (ID_ESTADO, NOME, ID_PAIS)
	VALUES (SEQ_ESTADO.nextval,'Massachussets', 2);
----------------------------------------------------CIDADE
	INSERT INTO CIDADE (ID_CIDADE, NOME, ID_ESTADO)
	VALUES (SEQ_CIDADE.nextval,'S�o Paulo', 1);

	INSERT INTO CIDADE (ID_CIDADE, NOME, ID_ESTADO)
	VALUES (SEQ_CIDADE.nextval,'Porto Alegre', 2);

	INSERT INTO CIDADE (ID_CIDADE, NOME, ID_ESTADO)
	VALUES (SEQ_CIDADE.nextval,'Syracuse', 3);

	INSERT INTO CIDADE (ID_CIDADE, NOME, ID_ESTADO)
	VALUES (SEQ_CIDADE.nextval,'Boston', 4);
----------------------------------------------------BAIRRO
	INSERT INTO BAIRRO (ID_BAIRRO, NOME, ID_CIDADE, ID_ESTADO)
	VALUES (SEQ_BAIRRO.nextval,'Tatuap�', 1, 1);

	INSERT INTO BAIRRO (ID_BAIRRO, NOME, ID_CIDADE, ID_ESTADO)
	VALUES (SEQ_BAIRRO.nextval,'Anchieta', 2, 2);	

	INSERT INTO BAIRRO (ID_BAIRRO, NOME, ID_CIDADE, ID_ESTADO)
	VALUES (SEQ_BAIRRO.nextval,'SouthSide', 3, 3);

	INSERT INTO BAIRRO (ID_BAIRRO, NOME, ID_CIDADE, ID_ESTADO)
	VALUES (SEQ_BAIRRO.nextval,'South Boston', 4, 4);
----------------------------------------------------ENDERE�O
	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Rua Tuiuti', '1', 'APTO', '12345-123', 1, 1);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Rua Celso Garcia', '2', 'CASA', '00000-000', 1, 1);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Avenida Severo Dullius', '3', 'CASA', '11111-111', 2, 2);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Rua Bernardino Bernardi', '4', 'APTO', '22222-222', 2, 2);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'E Genesee St', '5', 'APTO', '99999-999', 3, 3);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Harrison St', '6', 'CASA', '55555-555', 3, 3);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Park St', '7', 'APTO', '33333-999', 4, 4);

	INSERT INTO ENDERECO (ID_ENDERECO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, ID_BAIRRO, ID_CIDADE)
	VALUES (SEQ_ENDERECO.nextval,'Ashmont St', '8', 'CASA', '23456-000', 4, 4);
----------------------------------------------------FIM DOS INSERTS
----------------------------------------------------
----------------------------------------------------SELECTS HomeWork2
--DECRESCENTE
SELECT NOME 
FROM PAIS 
ORDER BY NOME 
DESC;

--LOGRADOURO E CEP
SELECT LOGRADOURO, CEP 
FROM ENDERECO 
WHERE UPPER(LOGRADOURO) 
LIKE 'A%';

--CEP FINAL C/ 0
SELECT CEP 
FROM ENDERECO 
WHERE TRIM(CEP) 
LIKE '%0';

--NUMEROS ENTRE 1 E 100
SELECT NUMERO 
FROM ENDERECO 
WHERE NUMERO >= 1 
AND NUMERO <= 100;

--COME�A POR RUA E ORDENA CEP EM DECRESCENTE
SELECT LOGRADOURO 
FROM ENDERECO 
WHERE UPPER(LOGRADOURO) 
LIKE 'RUA%' 
ORDER BY CEP 
DESC;

--QUANTIDADE ENDERE�OS CADASTRADOS
SELECT COUNT(LOGRADOURO) 
FROM ENDERECO

--AGRUPADOS PELO ID DA CIDADE
SELECT COUNT(LOGRADOURO) 
FROM ENDERECO 
GROUP BY (ID_CIDADE)

--EXERC�CIOS AULA 30/06/2022

UPDATE ENDERECO
SET LOGRADOURO = 'Rua Celso Garcia Garcia', 
	COMPLEMENTO = "CASA CASA"
WHERE ID_ENDERECO = 2;

UPDATE ENDERECO
SET LOGRADOURO = 'Avenida Severo Dullius Dullius',
	COMPLEMENTO  = 'CASA CASA'
WHERE ID_ENDERECO = 3;

UPDATE ENDERECO
SET NUMERO  = '999999'
WHERE ID_ENDERECO = 4;

DELETE 
FROM ENDERECO 
WHERE ID_ENDERECO = (
				SELECT MAX(ID_ENDERECO) 
				FROM ENDERECO
);

DELETE 
FROM ENDERECO 
WHERE NUMERO = 999999;

DELETE 
FROM ENDERECO 
WHERE ID_ENDERECO  = 5;

DELETE 
FROM ENDERECO 
WHERE ID_ENDERECO  = 6;

--EXERCICIOS AULA 30/06/2022 JOINS











	
	    
   