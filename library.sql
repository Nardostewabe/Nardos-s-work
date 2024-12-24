-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2024 at 04:54 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `available`
--

CREATE TABLE `available` (
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `available`
--

INSERT INTO `available` (`book_id`, `book_name`, `author`) VALUES
(2, 'the bible', 'God'),
(1, 'the codex', 'douglas preston');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(20) NOT NULL,
  `author` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `author`) VALUES
(2, 'the bible', 'God'),
(1, 'the codex', 'douglas preston');

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE `issued` (
  `username` varchar(30) DEFAULT NULL,
  `book_name` varchar(20) DEFAULT NULL,
  `issue_date` varchar(30) DEFAULT NULL,
  `period` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `passwords` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `passwords`) VALUES
('admin', 'admin01'),
('yohannes', 'yohannes2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `available`
--
ALTER TABLE `available`
  ADD KEY `book_name` (`book_name`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_name`);

--
-- Indexes for table `issued`
--
ALTER TABLE `issued`
  ADD KEY `username` (`username`),
  ADD KEY `book_name` (`book_name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `available`
--
ALTER TABLE `available`
  ADD CONSTRAINT `available_ibfk_1` FOREIGN KEY (`book_name`) REFERENCES `books` (`book_name`);

--
-- Constraints for table `issued`
--
ALTER TABLE `issued`
  ADD CONSTRAINT `issued_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  ADD CONSTRAINT `issued_ibfk_2` FOREIGN KEY (`book_name`) REFERENCES `books` (`book_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
