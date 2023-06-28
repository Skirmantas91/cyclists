-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2023 at 05:55 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `authorities` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `users` (`id`, `password`, `username`, `authorities`) VALUES
(2, '$2a$10$VWpOaEIzvYn3v3KagH2zz.RrjawlOZVrARKuyPIWybO6vJ3x11xAm', 'user', 'user'),
(3, '$2a$10$ckdpvlQ5IqRsz0RXT5BIYuTXq8.f0VIfeZj0iCmCzys/3rileKV9e', 'admin', 'user'),
(4, '$2a$10$VgzpGeXbt8iIlo1l3XQ.bO1eZ.7lsoxErJIVY4vouGyoigCQcjClq', 'petras', 'user'),
(5, '$2a$10$EmplsPqAFFbAJzikFwHugOmzybzMbnJfEBmvWZa6wycL4qcpLBtSa', 'jonas', 'user'),
(6, '$2a$10$2PaZxIcurMwJwxjHx008weG/iaulA5N5Q2HlYFKCrpuoFSNshAJnK', 'antanas', 'user'),
(7, '$2a$10$tqnzELvRlwWxjSIP4ugYOOBNg9xW9XFUaADsaWcieA0s/zkGVRohm', 'ona', 'user'),
(8, '$2a$10$CogGrfUG7pk.Wg93fqAqeui6.8KTfVL3Rw9AQzC7NnDfaf8.L1GRK', 'jonukas', 'user'),
(9, '$2a$10$6/meHcLyEF7VnRGF/jp8dOr8dAD/BpDe1LAs.c1ErGbJ5ZL5KEzM2', 'lova', 'user'),
(10, '$2a$10$ks/XbMstqAuPqjx9UfqpaOPCE9LncZSj5H707Oqg0OZpZb0k6suDe', 'lova2', 'user'),
(11, '$2a$10$ZbqF5jajyKj/pFUp0eNRNO4WZRPtcV8NFoyx.zqWQt7f3Qbf5nV0q', 'bamba', 'user'),
(12, '$2a$10$sYZz55h3PYeJX0m/u7ANguH7CxW5AWCCqjPRMR7lom1d6n0qq7nDW', 'antans', 'user'),
(13, '$2a$10$ZbhrcPTW16I1eXWm4Tk/b.IwUbHKn3JZkQpN9sqK2PbETqU5Az4N2', 'penktas', 'user'),
(14, '$2a$10$hiIwGV8sXAwuus7MfBT6EeES8TsccaEs6.Iqa/V9sBzj9Bw66O14u', 'penktad', 'user'),
(15, '$2a$10$8y5mH6ca.m8NdUS68HM0EuYa2wfTDUGt6bnRUVzAa9kpWM7BzOYyO', 'dddddd', 'user'),
(16, '$2a$10$.I4yPnyTlWVyLAA2pynnUur91UZWlCuGj4SK.NMfoYxIczbvAH7K.', 'ddddddd', 'user'),
(17, '$2a$10$5mLtjqDinafqTtK8CdZR..d7agqCddgfJN1iaMcEYuRYrkQpRPo0S', 'algis', 'user'),
(18, '$2a$10$GmEHi4KTucZbw24x8OtXiOgwAECSrW6zY9FkXarXuKU7vlOwBAeKm', 'algis69', 'user'),
(19, '$2a$10$AgA3JeyFlCo6G7Io45I1v.VsiLUjjPkloozwfgxw7XkvDxdEgSjiG', 'algis6969', 'user'),
(20, '$2a$10$kNvSLXychdpzjjFggo66eexP9U0hhBvUVwMq9N.TQWyUfJiX5.5d2', 'algyzas', 'user'),
(21, '$2a$10$jMuBMlZz0sCUWzzafUoOtelMdy0f7N0TYUyz8yi5dtngFJHOCHHUe', 'algyzas2', 'user'),
(22, '$2a$10$Dx8LoznNuw5hLJo9syho3uZXBIAWwp7M.fyDRcuo/xnmoTU0wL3xi', 'algyzas3', 'user'),
(23, '$2a$10$YhKHX9HiNWal0P1amkMA0uTch3p0FplRtQcg6JegBQvtobjLD.Zkm', 'algyzas4', 'user'),
(24, '$2a$10$.b./c.KBDQ6roVutoL7E2OLHVnZGNJ7Akyhm0Af.Rfwmd2g0aeHMO', 'admin69', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
