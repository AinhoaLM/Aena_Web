--
-- Base de datos: `airport_aena`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airplane`
--

CREATE TABLE IF NOT EXISTS `airplane` (
  `Id` int(11) NOT NULL,
  `Registration` varchar(11) DEFAULT NULL,
  `Model` varchar(10) DEFAULT NULL,
  `Msn` varchar(10) DEFAULT NULL,
  `NSeats` int(11) DEFAULT NULL,
  `IdState` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdState` (`IdState`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `airplane`
--

INSERT INTO `airplane` (`Id`, `Registration`, `Model`, `Msn`, `NSeats`, `IdState`) VALUES
(1, 'EC-LRR', 'ATR 42/72', '123', 68, 5),
(2, 'EC-LRU ', 'ATR 42/72', '1032', 0, 5),
(3, 'EC-LSQ ', 'ATR 42/72', '1041', 0, 5),
(4, 'EC-LQV', 'ATR 42/72', '995', 0, 5),
(5, 'EC-LRH ', 'ATR 42/72', '999', 74, 5),
(6, 'kkk', 'kkk', 'kkk', 0, NULL),
(7, 'AAA', 'Modelo', '111', 20, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airplane_state`
--

CREATE TABLE IF NOT EXISTS `airplane_state` (
  `Id` int(11) NOT NULL,
  `Code` int(11) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `airplane_state`
--

INSERT INTO `airplane_state` (`Id`, `Code`, `Description`) VALUES
(1, 10, 'Averiado'),
(2, 20, 'Retrasado'),
(3, 30, 'Saliendo'),
(4, 40, 'Llegando'),
(5, 50, 'Correcto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airport`
--

CREATE TABLE IF NOT EXISTS `airport` (
  `Id` int(11) NOT NULL,
  `Icao` varchar(4) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `NGates` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `airport`
--

INSERT INTO `airport` (`Id`, `Icao`, `Description`, `NGates`) VALUES
(1, 'LESO', 'Fuenterrabia-San Sebastian', 6),
(2, 'LESA', 'Matacán -Salamanca', 2),
(3, 'LEBB', 'Lujua/ La Paloma-Bilbao', 12),
(4, 'GCRR', 'Arrecife, Guacimeta, San Bartolomé-Lanzarote', 12),
(5, 'GCGM', 'La Gomera- La Gomera', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airport_gates`
--

CREATE TABLE IF NOT EXISTS `airport_gates` (
  `Id` int(11) NOT NULL,
  `Code` int(2) NOT NULL,
  `IdAirport` int(11) NOT NULL,
  `State` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `airplane`
--
ALTER TABLE `airplane`
  ADD CONSTRAINT `airplane_ibfk_1` FOREIGN KEY (`IdState`) REFERENCES `airplane_state` (`Id`);

  
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `LicenseCode` varchar(15) DEFAULT NULL,
  `ConcesionDate` date DEFAULT NULL,
  `ExpirationDate` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `company` CHANGE `ConcesionDate` `ConcessionDate` DATE NULL DEFAULT NULL 

INSERT INTO `company` (`Id`, `Name`, `LicenseCode`, `ConcessionDate`, `ExpirationDate`) VALUES
(1, 'Air Nostrum', NULL, '2015-01-01', '2015-12-31'),
(2, 'Air Europa', NULL, '2014-01-01', '2015-11-01'),
(3, 'Iberia', NULL, '2013-01-01', '2015-10-01');

ALTER TABLE `company` CHANGE `Id` `Id` INT( 11 ) NOT NULL AUTO_INCREMENT 
