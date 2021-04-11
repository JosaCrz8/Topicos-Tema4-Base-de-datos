-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2021 a las 01:53:12
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `topicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigoC` varchar(10) NOT NULL,
  `nombreC` varchar(50) NOT NULL,
  `apellidoC` varchar(45) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `telefono` int(10) NOT NULL,
  `estado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigoC`, `nombreC`, `apellidoC`, `direccion`, `telefono`, `estado`) VALUES
('C000', 'NJUNANS JAJJAA ', 'HAHAHA JJAJAJA', 'SUUCES', 1235256361, 'OAXACA'),
('C002', 'OLEA', 'GARCIA', 'BARRA PRIMERA', 1245631221, 'VERACRUZ'),
('C003', 'Aldahir', 'Rios', 'San Juan', 1254561231, 'Oaxaca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombre`, `cantidad`, `precio`, `categoria`) VALUES
('C0006', 'cocalcola 6', 10, 4.6, ''),
('C002', 'Producto de ejemplo 2', 10, 2, 'categoria 2'),
('C003', 'producto 2', 2, 10, 'categoria 3'),
('C010', 'MODELO', 25, 12.2, 'CATEORIA 1'),
('CD01', 'Producto de ejemplo 1', 5, 20.5, '1'),
('CD02', 'PRODUCTO DE EJEMPLO 2', 10, 5, 'categoria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `codigoProv` varchar(10) NOT NULL,
  `nombreProv` varchar(50) NOT NULL,
  `telefono` int(10) NOT NULL,
  `vendedor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`codigoProv`, `nombreProv`, `telefono`, `vendedor`) VALUES
('C002', 'DANIEL GUTIERREZ', 1234561234, 'VENDEDOR12'),
('C005', 'ALEJANDRO', 1245632112, 'vendedro5'),
('COO0', 'Josafeat', 1231234531, 'vendedor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigoC`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`codigoProv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
