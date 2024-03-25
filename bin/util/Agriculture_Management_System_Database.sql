-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ams
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crops`
--

DROP TABLE IF EXISTS `crops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crops` (
  `crop_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`crop_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crops`
--

LOCK TABLES `crops` WRITE;
/*!40000 ALTER TABLE `crops` DISABLE KEYS */;
INSERT INTO `crops` VALUES (1,'Cotton','Cotton is one of the most important fiber and cash crop of India and plays a\ndominant role in the industrial and agricultural economy of the country. It provides the\nbasic raw material (cotton fibre) to cotton textile industry. Cotton in India provides direct\nlivelihood to 6 million farmers and about 40 -50 million people are employed in cotton\ntrade and its processing.'),(2,'Wheat','The wheat crop requires a well-pulverized but compact seed bed for good and uniform germination.\nThree or four ploughings in the summer, repeated harrowing in the rainy season, followed by\nthree or four cultivations and planking immediately before sowing produce a good, firm seed\nbed for the dry crop on alluvial soils. For the irrigated crop, the land is given a pre-sowing\nirrigation (palewa or raund) and the number of ploughings is reduced. Where white ants or \nother pests are a problem, Aldrin 5% or BHC 10% dust at the rate of 25 kg/ha should be \napplied to the soil after the last ploughing or before planking.'),(3,'Potato','The potato, which originated in South America, is today grown all over the world. \nIt is a member of the nightshade family, Solanaceae, and is the world\'s most \nsignificant food crop. Potatoes are high in vitamins and minerals. According to \nthe 2018 data, potato production was 368 million tonnes. Raw potatoes contain a \nlot of water and starch.'),(4,'Red Chilli','The scientific name of red chilli is Capsicum annuum and it belongs to the family Solanaceae.\nRed Chili Powder is made from rare red, hot, and spicy red chilies collected from India\'s greatest farms.\nIt is somewhat heated and provides your food.\n');
/*!40000 ALTER TABLE `crops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetings`
--

DROP TABLE IF EXISTS `meetings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meetings` (
  `meeting_id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `date` varchar(15) DEFAULT NULL,
  `time` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetings`
--

LOCK TABLES `meetings` WRITE;
/*!40000 ALTER TABLE `meetings` DISABLE KEYS */;
INSERT INTO `meetings` VALUES (1,'Organic Farming','01/01/2023','10 A.M.'),(2,'Pesticides Precautions','01/01/2023','11 A.M.'),(3,'Pest Control','02/01/2023','2 P.M.');
/*!40000 ALTER TABLE `meetings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_queries`
--

DROP TABLE IF EXISTS `user_queries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_queries` (
  `query_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `query` mediumtext,
  PRIMARY KEY (`query_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_queries`
--

LOCK TABLES `user_queries` WRITE;
/*!40000 ALTER TABLE `user_queries` DISABLE KEYS */;
INSERT INTO `user_queries` VALUES (1004,'Vedant','7896523427','Lorem Ipsum is simply dummy text of the printing and typesetting industry.\nLorem Ipsum is simply dummy text of the printing and typesetting industry.\nLorem Ipsum is simply dummy text.\n');
/*!40000 ALTER TABLE `user_queries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','admin'),(2,'Vedant','Vedant123'),(14,'Ram','Ram14'),(23,'Tony1','Stark1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-30 20:31:32
