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

ALTER TABLE `airport_gates` CHANGE `State` `Status` TINYINT( 1 ) NOT NULL 
ALTER TABLE `airport_gates` CHANGE `Code` `Code` VARCHAR( 4 ) NOT NULL 

ALTER TABLE `airplane` ADD UNIQUE (`Registration`)
ALTER TABLE `airplane` ADD `IdCompany` INT NOT NULL AFTER `IdState` 
ALTER TABLE `airplane` CHANGE `Registration` `PlateNumber` VARCHAR( 11 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL
ALTER TABLE `airport_aena`.`airplane` DROP INDEX `Registration` ,ADD UNIQUE `PlateNumber` ( `PlateNumber` )
ALTER TABLE `airplane_state` ADD UNIQUE (`Code`) 
ALTER TABLE `company` ADD UNIQUE (`LicenseCode`)
ALTER TABLE `company` CHANGE `Id` `Id` BIGINT( 11 ) NOT NULL AUTO_INCREMENT 
ALTER TABLE `company` CHANGE `LicenseCode` `LicenseCode` VARCHAR( 15 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL 
ALTER TABLE `airplane` CHANGE `IdState` `IdState` INT( 11 ) NOT NULL 
ALTER TABLE `airport` ADD `Country` VARCHAR( 50 ) NOT NULL AFTER `NGates` 
ALTER TABLE `airport` ADD UNIQUE (`Icao`)

UPDATE `airport_aena`.`airport` SET `Country` = 'España' WHERE `airport`.`Id` =1;
UPDATE `airport_aena`.`airport` SET `Country` = 'España' WHERE `airport`.`Id` =2;
UPDATE `airport_aena`.`airport` SET `Country` = 'España' WHERE `airport`.`Id` =3;
UPDATE `airport_aena`.`airport` SET `Country` = 'España' WHERE `airport`.`Id` =4;
UPDATE `airport_aena`.`airport` SET `Country` = 'España' WHERE `airport`.`Id` =5;
ALTER TABLE `airport_gates` ADD UNIQUE (`Code` ,`IdAirport`);
ALTER TABLE `airplane` ADD INDEX ( `IdCompany` ) 
ALTER TABLE `airplane` ADD FOREIGN KEY ( `IdCompany` ) REFERENCES `airport_aena`.`company` (`Id`) 
ON DELETE RESTRICT ON UPDATE RESTRICT ;

ALTER TABLE `airport_gates` DROP `Status` ;
ALTER TABLE `airport_gates` ADD `IdAirplane` INT NULL AFTER `IdAirport` 
ALTER TABLE `airport_gates` ADD INDEX ( `IdAirport` ) 
ALTER TABLE `airport_gates` ADD FOREIGN KEY ( `IdAirport` ) REFERENCES `airport_aena`.`airport` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT ;


--
-- Estructura de tabla para la tabla `boardingpass`
--

CREATE TABLE IF NOT EXISTS `boardingpass` (
  `Id` int(11) NOT NULL,
  `Code` varchar(10) NOT NULL,
  `Seat` int(11) NOT NULL,
  `Boarded` tinyint(1) NOT NULL,
  `IdFlight` int(11) NOT NULL,
  `DNI` varchar(10) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code` (`Code`),
  UNIQUE KEY `Code_2` (`Code`,`DNI`),
  KEY `IdFlight` (`IdFlight`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `boardingpass`
--

INSERT INTO `boardingpass` (`Id`, `Code`, `Seat`, `Boarded`, `IdFlight`, `DNI`, `Name`, `FirstName`, `Birthday`) VALUES
(1, 'T001', 1, 1, 1, '11111111A', 'Pasajero 1', NULL, NULL),
(2, 'T002', 2, 1, 1, '22222222A', 'Pasajero 2', NULL, NULL),
(3, 'T003', 3, 0, 1, '33333333A', 'Pasjero 3 que no embarca', NULL, NULL),
(4, 'T004', 4, 1, 1, '44444444A', 'Pasajero 4', NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boardingpass`
--
ALTER TABLE `boardingpass`
  ADD CONSTRAINT `boardingpass_ibfk_1` FOREIGN KEY (`IdFlight`) REFERENCES `flight` (`Id`);
--
-- Estructura de tabla para la tabla `flight`
--

CREATE TABLE IF NOT EXISTS `flight` (
  `Id` int(11) NOT NULL,
  `IdAirportO` int(11) NOT NULL,
  `IdAirportD` int(11) DEFAULT NULL,
  `IdAirplane` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  `Date` date NOT NULL,
  `DepartureTime` datetime NOT NULL,
  `ArrivalTime` datetime NOT NULL,
  `Code` varchar(10) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdAirportO` (`IdAirportO`),
  KEY `IdAirportD` (`IdAirportD`),
  KEY `IdAirplane` (`IdAirplane`),
  KEY `IdCompany` (`IdCompany`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `flight`
--

INSERT INTO `flight` (`Id`, `IdAirportO`, `IdAirportD`, `IdAirplane`, `IdCompany`, `Date`, `DepartureTime`, `ArrivalTime`, `Code`) VALUES
(1, 1, 5, 1, 1, '2015-04-19', '2015-04-19 10:00:00', '2015-04-19 13:00:00', 'V001'),
(2, 1, NULL, 2, 2, '2015-04-19', '2015-04-19 15:00:00', '2015-04-19 18:00:00', 'V002');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`IdAirportO`) REFERENCES `airport` (`Id`),
  ADD CONSTRAINT `flight_ibfk_3` FOREIGN KEY (`IdAirportD`) REFERENCES `airport` (`Id`),
  ADD CONSTRAINT `flight_ibfk_5` FOREIGN KEY (`IdAirplane`) REFERENCES `airplane` (`Id`),
  ADD CONSTRAINT `flight_ibfk_6` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`Id`);



