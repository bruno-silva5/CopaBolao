CREATE DATABASE A3_COPA_DO_MUNDO;
USE A3_COPA_DO_MUNDO;


/* Inicio Criação das Tabelas */
CREATE TABLE TB_NIVELACESSO(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30)
);

CREATE TABLE TB_USER(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30),
 senha varchar(30),
 email VARCHAR(30),
 saldo DOUBLE,
 id_nivelAcesso integer
);

CREATE TABLE TB_GRUPO(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 descricao VARCHAR(30)
);


CREATE TABLE TB_TIME(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30),
 id_grupo integer
);

CREATE TABLE TB_PARTIDA(
 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
 id_time1 integer,
 id_time2 integer,
 qtd_gols_time1 int,
 qtd_gols_time2 int,
 dt_partida datetime
);

CREATE TABLE TB_APOSTA(
 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
 valor double,
 id_usuario integer,
 id_partida integer,
 id_time integer
);
/* Fim Criação das Tabelas */

/* Inicio da adição das chaves estrangeiras */

ALTER TABLE `TB_USER` ADD CONSTRAINT `FK_Nivel_De_Acesso` FOREIGN KEY ( `id_nivelAcesso` ) REFERENCES `TB_NIVELACESSO` ( `id` ) ;

ALTER TABLE `TB_TIME` ADD CONSTRAINT `FK_Grupo_Do_Time` FOREIGN KEY ( `id_grupo` ) REFERENCES `TB_GRUPO` ( `id` ) ;

ALTER TABLE `TB_PARTIDA` ADD CONSTRAINT `FK_Time1` FOREIGN KEY ( `id_time1` ) REFERENCES `TB_TIME` ( `id` ) ;
ALTER TABLE `TB_PARTIDA` ADD CONSTRAINT `FK_Time2` FOREIGN KEY ( `id_time2` ) REFERENCES `TB_TIME` ( `id` ) ;

ALTER TABLE `TB_APOSTA` ADD CONSTRAINT `FK_User_Aposta` FOREIGN KEY ( `id_usuario` ) REFERENCES `TB_USER` ( `id` ) ;
ALTER TABLE `TB_APOSTA` ADD CONSTRAINT `FK_Aposta` FOREIGN KEY ( `id_partida` ) REFERENCES `TB_PARTIDA` ( `id` ) ;
ALTER TABLE `TB_APOSTA` ADD CONSTRAINT `FK_Time_Aposta` FOREIGN KEY ( `id_time` ) REFERENCES `TB_TIME` ( `id` ) ;

/* Fim da adição das chaves estrangeiras */

/* Inicio Criação das Procs */

/* Login */
DELIMITER //
CREATE PROCEDURE LOGIN(
 USERNAME VARCHAR(30),
 PASS VARCHAR(30)
)
BEGIN
	SELECT 
		id,
		nome,
		senha,
		email,
		saldo,
		`TB_NIVELACESSO`.nome
	FROM 
		`TB_USER` 
	JOIN 
		`TB_NIVELACESSO` ON `TB_NIVELACESSO`.`id` = `TB_USER`.`id_nivelAcesso`
	WHERE 
		`email` = USERNAME AND `senha` = PASS;
END //
DELIMITER ;

/* Fim Criação das Procs */

