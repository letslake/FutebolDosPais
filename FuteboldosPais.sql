-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FutebolDosPais
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FutebolDosPais` ;

-- -----------------------------------------------------
-- Schema FutebolDosPais
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FutebolDosPais` DEFAULT CHARACTER SET utf8 ;
USE `FutebolDosPais` ;

-- -----------------------------------------------------
-- Table `FutebolDosPais`.`CAMPEONATOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`CAMPEONATOS` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`CAMPEONATOS` (
  `idCampeonatos` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `data_inicio` DATE NULL,
  `data_termino` DATE NULL,
  `qtd_atletas` INT NULL,
  `partidas` INT NULL,
  `data_partida` DATE NULL,
  `hora_inicio` VARCHAR(45) NULL,
  `hora_termino` VARCHAR(45) NULL,
  `qtd_partida` INT NULL,
  PRIMARY KEY (`idCampeonatos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`ARBITROS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`ARBITROS` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`ARBITROS` (
  `id_arbitros` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` INT NULL,
  `partidas` INT NULL,
  `media_notas` INT NULL,
  `qtd_amarelo` INT NULL,
  `qtd_vermelho` INT NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_arbitros`))
ENGINE = TokuDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`TURNO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`TURNO` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`TURNO` (
  `id_turno` INT NOT NULL,
  `tipo_turno` VARCHAR(45) NULL,
  PRIMARY KEY (`id_turno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`EQUIPES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`EQUIPES` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`EQUIPES` (
  `id_equipe` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `bandeira` VARCHAR(45) NULL,
  `vitoria` INT NULL,
  `derrotas` INT NULL,
  `empates` INT NULL,
  `qtd_jogos` INT NULL,
  `media_jogo` INT NULL,
  PRIMARY KEY (`id_equipe`))
ENGINE = EXAMPLE;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`JOGADORES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`JOGADORES` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`JOGADORES` (
  `id_jogador` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `posicao` VARCHAR(45) NULL,
  `camisa` INT NULL,
  `data_nasc` DATE NULL,
  `qtd_cartao` INT NULL,
  `qtd_gols` INT NULL,
  `qtd_gols_contra` INT NULL,
  `equipe` INT NULL,
  `categoria` VARCHAR(45) NULL,
  `altura` FLOAT NULL,
  `peso` FLOAT NULL,
  `tipo_cartao` VARCHAR(45) NULL,
  `foto` VARCHAR(45) NULL,
  PRIMARY KEY (`id_jogador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`SUMULA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`SUMULA` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`SUMULA` (
  `id_sumula` INT NOT NULL,
  `partida` VARCHAR(45) NULL,
  `qtd_gols` INT NULL,
  `gols_sofridos` INT NULL,
  `gols_feitos` INT NULL,
  `qtd_cartao_vermelho` INT NULL,
  `qtd_cartao_amarelo` INT NULL,
  `pontos_ganhos` INT NULL,
  `pontos_disc` INT NULL,
  `nome_equipe` VARCHAR(45) NULL,
  PRIMARY KEY (`id_sumula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`LOCAL_PARTIDA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`LOCAL_PARTIDA` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`LOCAL_PARTIDA` (
  `id_local_partida` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id_local_partida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`CATEGORIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`CATEGORIA` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`CATEGORIA` (
  `id_categoria` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FutebolDosPais`.`TECNICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FutebolDosPais`.`TECNICO` ;

CREATE TABLE IF NOT EXISTS `FutebolDosPais`.`TECNICO` (
  `id_tecnico` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` INT NULL,
  PRIMARY KEY (`id_tecnico`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
