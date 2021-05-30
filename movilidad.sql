-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-05-2021 a las 22:10:52
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `movilidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` int(11) DEFAULT NULL,
  `plaque` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `trade_mark` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs0dcjp3mjm2pn9435ey8ba0w4` (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cars`
--

INSERT INTO `cars` (`id`, `model`, `plaque`, `trade_mark`, `driver_id`) VALUES
(1, 2020, 'KUG19D', 'Chevrolet', 1),
(2, 2016, 'KYC456', 'NISSAN', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `displacements`
--

DROP TABLE IF EXISTS `displacements`;
CREATE TABLE IF NOT EXISTS `displacements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `destination` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `destination_date` datetime(6) DEFAULT NULL,
  `origin` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `origin_date` datetime(6) DEFAULT NULL,
  `plaque` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `displacements`
--

INSERT INTO `displacements` (`id`, `destination`, `destination_date`, `origin`, `origin_date`, `plaque`) VALUES
(1, 'Bogota', '2021-05-30 00:00:00.000000', 'Neiva', '2021-05-30 00:00:00.000000', 'KUG19D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `drivers`
--

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE IF NOT EXISTS `drivers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7cs77i09tjj1ja8mhd4tii4xp` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `drivers`
--

INSERT INTO `drivers` (`id`, `name`) VALUES
(1, 'Diego Andrés Roldán Lozano'),
(3, 'Juan Diego Roldán Perdomo'),
(2, 'Maria Paula Perdomo Rojas'),
(4, 'Santiago Gutierrez Perdomo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `full_name`, `password`, `user_name`) VALUES
(1, 'Diego Roldán', '$2a$10$62NMSHcXKeONblD37Q9VL.YVOEsPUMymn7zu8zFUDvZ.ShIB/LZcO', 'darl.8910');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `FKs0dcjp3mjm2pn9435ey8ba0w4` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
