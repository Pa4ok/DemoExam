-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Ноя 09 2021 г., 13:51
-- Версия сервера: 5.7.36-0ubuntu0.18.04.1
-- Версия PHP: 7.3.29-1+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `DemoExam`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Manufacturer`
--

CREATE TABLE `Manufacturer` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL,
  `StartDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Manufacturer`
--

INSERT INTO `Manufacturer` (`ID`, `Name`, `StartDate`) VALUES
(1, 'Natura Siberica', '2018-01-20'),
(2, 'Биопин ФАРМА', '2016-08-13'),
(3, 'Milotto', '2016-06-19'),
(4, 'Лаборатория натуральной косметики MIXIT', '2018-06-12'),
(5, 'Малавит', '2017-09-18'),
(6, 'ANDALOU', '2015-11-11'),
(7, 'Agent Netty PRO', '2016-03-17'),
(8, 'ЕвроТек', '2017-10-21'),
(9, 'Blue Beautifly', '2017-01-15'),
(10, 'MATSESTA', '2018-04-21'),
(11, 'АЙРОН БАРБЕР', '2018-04-16'),
(12, 'РУСХИМТЕХ', '2017-07-03'),
(13, 'НИКОЛЬ', '2017-02-27'),
(14, 'Аравия', '2015-06-23'),
(15, 'Алтэя', '2018-05-14'),
(16, 'SHELK Cosmetics', '2017-01-19'),
(17, 'Русская косметика', '2015-07-19'),
(18, 'MAGIC HERBS', '2016-02-23'),
(19, 'Natura Botanica', '2016-05-02'),
(20, 'Bel Savon', '2015-04-20'),
(21, 'ИРИДА-НЕВА', '2017-05-27'),
(22, 'Славяна', '2015-03-09'),
(23, 'АЛВА', '2016-08-18'),
(24, 'Альпика', '2018-05-31'),
(25, 'Жерминаль', '2017-04-04'),
(26, 'Арт-Визаж', '2018-04-15'),
(27, 'Валери-Д', '2018-06-28'),
(28, 'Мастерская Fitoland Organic', '2017-07-10'),
(29, 'ДОМ ПРИРОДЫ', '2015-11-25'),
(30, 'Флора', '2016-01-18'),
(31, 'ЭКО ТАВРИДА', '2016-06-27'),
(32, 'АлтайЯ', '2015-07-04'),
(33, 'Weleda', '2015-04-14'),
(34, 'ANTI AGE', '2015-11-01'),
(35, 'Колорит', '2017-12-22'),
(36, 'SATIVA', '2017-01-13'),
(37, 'Фитокосметик', '2016-03-01'),
(38, 'Клеона', '2017-10-29'),
(39, 'Живая косметика Сибири', '2015-03-05'),
(40, 'SLAVIC HAIR Company', '2015-12-20'),
(41, 'Green era', '2017-07-28'),
(42, 'SIBERINA', '2015-10-01'),
(43, 'Green Mama', '2016-11-11'),
(44, 'Altanya', '2015-03-23'),
(45, 'Черный бриллиант', '2016-01-07'),
(46, 'BIOSelect', '2016-12-29'),
(47, 'АромаВятка', '2016-10-01'),
(48, 'VIQQO — производитель инновационной уходовой косметики', '2017-10-12'),
(49, 'DIONY', '2017-12-03'),
(50, 'AMSARVEDA', '2015-12-11');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Manufacturer`
--
ALTER TABLE `Manufacturer`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Manufacturer`
--
ALTER TABLE `Manufacturer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
