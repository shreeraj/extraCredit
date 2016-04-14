-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 15, 2016 at 12:48 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imdbSpring`
--
CREATE DATABASE IF NOT EXISTS `imdbSpring` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `imdbSpring`;

-- --------------------------------------------------------

--
-- Table structure for table `Artist`
--

CREATE TABLE `Artist` (
  `artist_Id` int(11) NOT NULL,
  `DOB` varchar(255) DEFAULT NULL,
  `POB` varchar(255) DEFAULT NULL,
  `biography` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Artist`
--

INSERT INTO `Artist` (`artist_Id`, `DOB`, `POB`, `biography`, `name`) VALUES
(4, '1993/08/13', 'surkhet', 'very good artist', 'shree raj karki'),
(9, '1993/08/13', 'gfd', 'very good artist', 'ram bahadur'),
(12, '1993/08/13', 'surkhet', 'very good artist', 'Rikesh'),
(13, '08/13/1990', 'fds', 'good artist', 'Shailesh');

-- --------------------------------------------------------

--
-- Table structure for table `Director`
--

CREATE TABLE `Director` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Director`
--

INSERT INTO `Director` (`id`, `name`) VALUES
(4, 'Prabhat paudel'),
(9, 'john'),
(12, 'Hari'),
(13, 'Krishna');

-- --------------------------------------------------------

--
-- Table structure for table `Movie`
--

CREATE TABLE `Movie` (
  `id` int(11) NOT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Movie`
--

INSERT INTO `Movie` (`id`, `poster`, `rating`, `summary`, `title`, `year`) VALUES
(3, NULL, 'GOOD', 'das', 'Avengers', '2015'),
(6, NULL, 'GOOD', 'very good movie', 'Nai navannu la', '2017');

-- --------------------------------------------------------

--
-- Table structure for table `Movie_Artist`
--

CREATE TABLE `Movie_Artist` (
  `movies_id` int(11) NOT NULL,
  `artist_artist_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Movie_Artist`
--

INSERT INTO `Movie_Artist` (`movies_id`, `artist_artist_Id`) VALUES
(3, 4),
(6, 12),
(6, 13);

-- --------------------------------------------------------

--
-- Table structure for table `Movie_Director`
--

CREATE TABLE `Movie_Director` (
  `movie_id` int(11) NOT NULL,
  `director_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Movie_Director`
--

INSERT INTO `Movie_Director` (`movie_id`, `director_id`) VALUES
(3, 4),
(6, 12),
(6, 13);

-- --------------------------------------------------------

--
-- Table structure for table `Movie_comment`
--

CREATE TABLE `Movie_comment` (
  `Movie_id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `comment_index` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Movie_genere`
--

CREATE TABLE `Movie_genere` (
  `Movie_id` int(11) NOT NULL,
  `genere` varchar(255) DEFAULT NULL,
  `index_genere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Movie_genere`
--

INSERT INTO `Movie_genere` (`Movie_id`, `genere`, `index_genere`) VALUES
(3, 'COMEDY', 0),
(3, 'ACTION', 1),
(6, 'ACTION', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Picture`
--

CREATE TABLE `Picture` (
  `pic_id` int(11) NOT NULL,
  `pic` longblob,
  `artist_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Artist`
--
ALTER TABLE `Artist`
  ADD PRIMARY KEY (`artist_Id`);

--
-- Indexes for table `Director`
--
ALTER TABLE `Director`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Movie`
--
ALTER TABLE `Movie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Movie_Artist`
--
ALTER TABLE `Movie_Artist`
  ADD KEY `FK_5uhx0v65j0mgg6c0qody60h1a` (`artist_artist_Id`),
  ADD KEY `FK_gjtfu3x26l6xhtae94coetn0d` (`movies_id`);

--
-- Indexes for table `Movie_Director`
--
ALTER TABLE `Movie_Director`
  ADD KEY `FK_ay6ccv877j6gdum5yo09qdxi` (`director_id`),
  ADD KEY `FK_h5ma6qfkki2jn6db894alq2t0` (`movie_id`);

--
-- Indexes for table `Movie_comment`
--
ALTER TABLE `Movie_comment`
  ADD PRIMARY KEY (`Movie_id`,`comment_index`);

--
-- Indexes for table `Movie_genere`
--
ALTER TABLE `Movie_genere`
  ADD PRIMARY KEY (`Movie_id`,`index_genere`);

--
-- Indexes for table `Picture`
--
ALTER TABLE `Picture`
  ADD PRIMARY KEY (`pic_id`),
  ADD KEY `FK_stocslowdcfgr7e7l0k3h682i` (`artist_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Artist`
--
ALTER TABLE `Artist`
  MODIFY `artist_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Director`
--
ALTER TABLE `Director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Movie`
--
ALTER TABLE `Movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `Picture`
--
ALTER TABLE `Picture`
  MODIFY `pic_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Movie_Artist`
--
ALTER TABLE `Movie_Artist`
  ADD CONSTRAINT `FK_5uhx0v65j0mgg6c0qody60h1a` FOREIGN KEY (`artist_artist_Id`) REFERENCES `Artist` (`artist_Id`),
  ADD CONSTRAINT `FK_gjtfu3x26l6xhtae94coetn0d` FOREIGN KEY (`movies_id`) REFERENCES `Movie` (`id`);

--
-- Constraints for table `Movie_Director`
--
ALTER TABLE `Movie_Director`
  ADD CONSTRAINT `FK_ay6ccv877j6gdum5yo09qdxi` FOREIGN KEY (`director_id`) REFERENCES `Director` (`id`),
  ADD CONSTRAINT `FK_h5ma6qfkki2jn6db894alq2t0` FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`id`);

--
-- Constraints for table `Movie_comment`
--
ALTER TABLE `Movie_comment`
  ADD CONSTRAINT `FK_oh4q0orcmea5a6r3ir742t5b4` FOREIGN KEY (`Movie_id`) REFERENCES `Movie` (`id`);

--
-- Constraints for table `Movie_genere`
--
ALTER TABLE `Movie_genere`
  ADD CONSTRAINT `FK_oalvv33ar8gxhouqmg55mawyv` FOREIGN KEY (`Movie_id`) REFERENCES `Movie` (`id`);

--
-- Constraints for table `Picture`
--
ALTER TABLE `Picture`
  ADD CONSTRAINT `FK_stocslowdcfgr7e7l0k3h682i` FOREIGN KEY (`artist_id`) REFERENCES `Artist` (`artist_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
