-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.31 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para examen
DROP DATABASE IF EXISTS `examen`;
CREATE DATABASE IF NOT EXISTS `examen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `examen`;

-- Volcando estructura para tabla examen.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `cve_usuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `cliente` float DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fechaalta` date DEFAULT NULL,
  `fechabaja` date DEFAULT NULL,
  `status` char(50) DEFAULT NULL,
  `intentos` float DEFAULT NULL,
  `fecharevocado` date DEFAULT NULL,
  `fecha_vigencia` date DEFAULT NULL,
  `no_acceso` int DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `area` int DEFAULT NULL,
  `fecha_modificacion` int DEFAULT NULL,
  PRIMARY KEY (`cve_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla examen.usuario: 5 rows
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`cve_usuario`, `login`, `password`, `nombre`, `cliente`, `email`, `fechaalta`, `fechabaja`, `status`, `intentos`, `fecharevocado`, `fecha_vigencia`, `no_acceso`, `apellido_paterno`, `apellido_materno`, `area`, `fecha_modificacion`) VALUES
	(1, 'admin', 'MTIz', 'Gerardo', NULL, NULL, '2023-09-09', NULL, '1', NULL, NULL, '2023-09-01', NULL, NULL, NULL, NULL, NULL),
	(3, 'ADMIN2', 'MTIzNA==', 'Gerardo', NULL, NULL, '2023-09-01', NULL, '1', NULL, '2023-09-02', '2023-09-09', NULL, NULL, NULL, NULL, NULL),
	(4, 'asd', 'MTIz', 'asd', NULL, NULL, '2023-09-01', NULL, '0', NULL, '2023-09-02', '2023-09-09', NULL, NULL, NULL, NULL, NULL),
	(6, 'ADMIN2', 'MTIz', 'Gerardo', NULL, NULL, '2023-09-02', NULL, '0', NULL, '2023-09-02', '2023-09-09', NULL, NULL, NULL, NULL, NULL),
	(7, 'prueba', 'MTIz', 'sdsdf', NULL, NULL, '2023-09-02', NULL, '1', NULL, NULL, '2023-09-09', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
