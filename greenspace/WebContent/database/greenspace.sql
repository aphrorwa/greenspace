-- MySQL dump 10.13  Distrib 5.1.54, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: greenspace
-- ------------------------------------------------------
-- Server version	5.1.54-1ubuntu4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `greenspace`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `greenspace` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `greenspace`;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `locationDescription` varchar(255) DEFAULT NULL,
  `locationName` varchar(255) NOT NULL,
  `seed_id` int(11) DEFAULT NULL,
  `locationCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK714F9FB59BB77F8A` (`seed_id`),
  CONSTRAINT `FK714F9FB59BB77F8A` FOREIGN KEY (`seed_id`) REFERENCES `seed` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'The Main City Of Rwanda','Kigali City',NULL,NULL),(2,'Near Burundi Country','Kamabuye',NULL,NULL),(4,'Nyarubuye Sector','Nyagasambu',NULL,'rwkibunya');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_seed`
--

DROP TABLE IF EXISTS `location_seed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_seed` (
  `seed_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  KEY `FK94E970BB9BB77F8A` (`seed_id`),
  KEY `FK94E970BB9413910A` (`location_id`),
  CONSTRAINT `FK94E970BB9413910A` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK94E970BB9BB77F8A` FOREIGN KEY (`seed_id`) REFERENCES `seed` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_seed`
--

LOCK TABLES `location_seed` WRITE;
/*!40000 ALTER TABLE `location_seed` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_seed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_tree_harvested`
--

DROP TABLE IF EXISTS `location_tree_harvested`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_tree_harvested` (
  `location_id` int(11) NOT NULL,
  `treeHarvesteds_id` int(11) NOT NULL,
  UNIQUE KEY `treeHarvesteds_id` (`treeHarvesteds_id`),
  KEY `FK475D70319413910A` (`location_id`),
  KEY `FK475D7031267D81AB` (`treeHarvesteds_id`),
  CONSTRAINT `FK475D7031267D81AB` FOREIGN KEY (`treeHarvesteds_id`) REFERENCES `tree_harvested` (`id`),
  CONSTRAINT `FK475D70319413910A` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_tree_harvested`
--

LOCK TABLES `location_tree_harvested` WRITE;
/*!40000 ALTER TABLE `location_tree_harvested` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_tree_harvested` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_tree_planted`
--

DROP TABLE IF EXISTS `location_tree_planted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_tree_planted` (
  `location_id` int(11) NOT NULL,
  `treePlants_id` int(11) NOT NULL,
  UNIQUE KEY `treePlants_id` (`treePlants_id`),
  KEY `FK75294CF39413910A` (`location_id`),
  KEY `FK75294CF3C777E4D0` (`treePlants_id`),
  CONSTRAINT `FK75294CF39413910A` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK75294CF3C777E4D0` FOREIGN KEY (`treePlants_id`) REFERENCES `tree_planted` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_tree_planted`
--

LOCK TABLES `location_tree_planted` WRITE;
/*!40000 ALTER TABLE `location_tree_planted` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_tree_planted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seed`
--

DROP TABLE IF EXISTS `seed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `seedQuantity` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35CE711D6F494A` (`user_id`),
  CONSTRAINT `FK35CE711D6F494A` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seed`
--

LOCK TABLES `seed` WRITE;
/*!40000 ALTER TABLE `seed` DISABLE KEYS */;
INSERT INTO `seed` VALUES (2,'2011-12-13',67,NULL),(3,'2011-12-13',23,NULL),(4,'2011-12-21',45,NULL);
/*!40000 ALTER TABLE `seed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tree`
--

DROP TABLE IF EXISTS `tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `treeDescription` varchar(255) DEFAULT NULL,
  `treeName` varchar(255) NOT NULL,
  `seed_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK36739E9BB77F8A` (`seed_id`),
  CONSTRAINT `FK36739E9BB77F8A` FOREIGN KEY (`seed_id`) REFERENCES `seed` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tree`
--

LOCK TABLES `tree` WRITE;
/*!40000 ALTER TABLE `tree` DISABLE KEYS */;
INSERT INTO `tree` VALUES (1,'Euca','eucarptus',NULL),(2,'GRE','Grevilea',NULL),(3,'23','57',NULL);
/*!40000 ALTER TABLE `tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tree_harvested`
--

DROP TABLE IF EXISTS `tree_harvested`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tree_harvested` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `harvesterName` varchar(255) DEFAULT NULL,
  `observation` varchar(255) DEFAULT NULL,
  `seedQuantity` int(11) NOT NULL,
  `treePlanted_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF330A2674F68E4AA` (`treePlanted_id`),
  KEY `FKF330A2679413910A` (`location_id`),
  KEY `FKF330A2671D6F494A` (`user_id`),
  CONSTRAINT `FKF330A2671D6F494A` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKF330A2674F68E4AA` FOREIGN KEY (`treePlanted_id`) REFERENCES `tree_planted` (`id`),
  CONSTRAINT `FKF330A2679413910A` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tree_harvested`
--

LOCK TABLES `tree_harvested` WRITE;
/*!40000 ALTER TABLE `tree_harvested` DISABLE KEYS */;
/*!40000 ALTER TABLE `tree_harvested` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tree_planted`
--

DROP TABLE IF EXISTS `tree_planted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tree_planted` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `seedQuantity` int(11) NOT NULL,
  `seed_id` int(11) DEFAULT NULL,
  `treeQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK196F94A99BB77F8A` (`seed_id`),
  CONSTRAINT `FK196F94A99BB77F8A` FOREIGN KEY (`seed_id`) REFERENCES `seed` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tree_planted`
--

LOCK TABLES `tree_planted` WRITE;
/*!40000 ALTER TABLE `tree_planted` DISABLE KEYS */;
/*!40000 ALTER TABLE `tree_planted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aphro','aphro',0,'admin','aphro'),(2,'rwa','rwa',0,'user','rwa');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-12-23 20:26:49
