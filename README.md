# desafio-acesso

Projeto feito em java utilizando:
-Spring boot versão 1.5.9
-Maven 3.5.0
-MySql 5.7

O projeto possui uma autenticação feita em memória com o user="acesso" e password="123456", podem ser vistos e alterados 
dentro da classe WebSecurityConfig.

O projeto pode ser executado na porta 8080 acessando a pasta desafio -> target e executar o comando:
java -jar desafio-0.0.1-SNAPSHOT.jar

As configurações do banco de dados e da porta de acesso estão no arquivo application.properties e podem ser alterados
de acordo com a necessidade.

Tive problemas com a parte do update, meu controller possui a logica que estava seguindo, mas o botão não é funcional.

Descrição da tabela:

CREATE DATABASE IF NOT EXISTS `desafio_acesso`;
USE `desafio_acesso`;

CREATE TABLE IF NOT EXISTS `gerenciador` (
   id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
   servico varchar(200) NOT NULL,
   email varchar(200),
   senha varchar(200) NOT NULL
);

