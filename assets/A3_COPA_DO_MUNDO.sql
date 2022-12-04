CREATE DATABASE A3_COPA_DO_MUNDO;
USE A3_COPA_DO_MUNDO;


/* Inicio Criação das Tabelas */
CREATE TABLE tb_nivelacesso(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30)
);

CREATE TABLE tb_user(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30),
 senha varchar(30),
 email VARCHAR(30),
 saldo DOUBLE,
 id_nivelAcesso integer
);

CREATE TABLE tb_grupo(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 descricao VARCHAR(30)
);


CREATE TABLE tb_time(
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 nome VARCHAR(30),
 id_grupo integer
);

CREATE TABLE tb_partida(
 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
 id_time1 integer,
 id_time2 integer,
 qtd_gols_time1 int,
 qtd_gols_time2 int,
 dt_partida datetime
);

CREATE TABLE tb_aposta(
 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
 valor double,
 id_usuario integer,
 id_partida integer,
 id_time integer
);

CREATE TABLE TB_FASE(
 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
 descricao varchar(30)
);

/* Fim Criação das Tabelas */

/* Inicio da adição das chaves estrangeiras */

ALTER TABLE `tb_user` ADD CONSTRAINT `FK_Nivel_De_Acesso` FOREIGN KEY ( `id_nivelAcesso` ) REFERENCES `tb_nivelacesso` ( `id` ) ;

ALTER TABLE `tb_time` ADD CONSTRAINT `FK_Grupo_Do_Time` FOREIGN KEY ( `id_grupo` ) REFERENCES `tb_grupo` ( `id` ) ;

ALTER TABLE `tb_partida` ADD CONSTRAINT `FK_Time1` FOREIGN KEY ( `id_time1` ) REFERENCES `tb_time` ( `id` ) ;
ALTER TABLE `tb_partida` ADD CONSTRAINT `FK_Time2` FOREIGN KEY ( `id_time2` ) REFERENCES `tb_time` ( `id` ) ;

ALTER TABLE `tb_aposta` ADD CONSTRAINT `FK_User_Aposta` FOREIGN KEY ( `id_usuario` ) REFERENCES `tb_user` ( `id` ) ;
ALTER TABLE `tb_aposta` ADD CONSTRAINT `FK_Aposta` FOREIGN KEY ( `id_partida` ) REFERENCES `tb_partida` ( `id` ) ;
ALTER TABLE `tb_aposta` ADD CONSTRAINT `FK_Time_Aposta` FOREIGN KEY ( `id_time` ) REFERENCES `tb_time` ( `id` ) ;

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
		`tb_nivelacesso`.nome
	FROM 
		`tb_user` 
	JOIN 
		`tb_nivelacesso` ON `tb_nivelacesso`.`id` = `tb_user`.`id_nivelAcesso`
	WHERE 
		`email` = USERNAME AND `senha` = PASS;
END //
DELIMITER ;

INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(1,2,0,2,DATE("2022-11-29"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(3,4,1,3,DATE("2022-11-29"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(5,6,1,0,DATE("2022-11-28"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(7,8,2,1,DATE("2022-11-28"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(9,10,1,0,DATE("2022-11-27"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(11,12,3,0,DATE("2022-11-27"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(13,14,1,3,DATE("2022-11-26"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(15,16,3,0,DATE("2022-11-26"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(17,18,2,1,DATE("2022-11-25"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(19,20,1,2,DATE("2022-11-25"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(21,22,1,1,DATE("2022-11-24"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(23,24,2,0,DATE("2022-11-24"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(25,26,1,2,DATE("2022-11-23"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(27,28,1,1,DATE("2022-11-22"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(29,30,1,3,DATE("2022-11-21"));
INSERT INTO tb_partida (id_time1, id_time2, qtd_gols_time1, qtd_gols_time2, dt_partida) VALUES
(31,32,1,2,DATE("2022-11-20"));

/* Fim Criação das Procs */

