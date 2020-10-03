-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-10-2020 a las 22:06:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concessionaire`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bus`
--

CREATE TABLE `bus` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `motor` varchar(45) DEFAULT NULL,
  `brakes` varchar(45) DEFAULT NULL,
  `concessionaire_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `bus`
--

INSERT INTO `bus` (`id`, `type`, `motor`, `brakes`, `concessionaire_id`) VALUES
(1, 'Articulado', 'Diesel', 'abs', 1),
(2, 'Bi-articulado', 'Gas', 'Pinzas Flotantes', 1),
(3, 'Semi-articulado', 'Electric', 'Tambor', 2),
(4, 'Bi-articulado', 'Hybrid', 'Tambor', 1),
(5, 'Articulado', 'Hybrid', 'abs', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concessionaire`
--

CREATE TABLE `concessionaire` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `concessionaire`
--

INSERT INTO `concessionaire` (`id`, `name`) VALUES
(1, 'Concessionaire 1'),
(2, 'Concessionaire 2'),
(3, 'Concessionaire 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `device`
--

CREATE TABLE `device` (
  `id` int(11) NOT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `bus_id` int(11) NOT NULL,
  `device_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `device`
--

INSERT INTO `device` (`id`, `ip`, `status`, `bus_id`, `device_type_id`) VALUES
(1, '190.162.0.0', 'ACTIVE', 1, 2),
(2, '1.1.0.0', 'INACTIVE', 4, 2),
(3, '192.168.0.1', 'ACTIVE', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `device_type`
--

CREATE TABLE `device_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `device_type`
--

INSERT INTO `device_type` (`id`, `name`) VALUES
(1, 'CANBUS'),
(2, 'NVR');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bus_concessionaire_idx` (`concessionaire_id`);

--
-- Indices de la tabla `concessionaire`
--
ALTER TABLE `concessionaire`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_device_bus1_idx` (`bus_id`),
  ADD KEY `fk_device_device_type1_idx` (`device_type_id`);

--
-- Indices de la tabla `device_type`
--
ALTER TABLE `device_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bus`
--
ALTER TABLE `bus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `concessionaire`
--
ALTER TABLE `concessionaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `device`
--
ALTER TABLE `device`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `device_type`
--
ALTER TABLE `device_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `fk_bus_concessionaire` FOREIGN KEY (`concessionaire_id`) REFERENCES `concessionaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `fk_device_bus1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_device_device_type1` FOREIGN KEY (`device_type_id`) REFERENCES `device_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
