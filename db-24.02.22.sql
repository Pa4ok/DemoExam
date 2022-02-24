CREATE DATABASE  IF NOT EXISTS `demoexam3` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demoexam3`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: demoexam3
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AgentTypeID` int NOT NULL,
  `Address` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `INN` varchar(12) NOT NULL,
  `KPP` varchar(9) DEFAULT NULL,
  `DirectorName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Logo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Priority` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Agent_AgentType` (`AgentTypeID`),
  CONSTRAINT `FK_Agent_AgentType` FOREIGN KEY (`AgentTypeID`) REFERENCES `agenttype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agentpriorityhistory`
--

DROP TABLE IF EXISTS `agentpriorityhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agentpriorityhistory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AgentID` int NOT NULL,
  `ChangeDate` datetime(6) NOT NULL,
  `PriorityValue` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_AgentPriorityHistory_Agent` (`AgentID`),
  CONSTRAINT `FK_AgentPriorityHistory_Agent` FOREIGN KEY (`AgentID`) REFERENCES `agent` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agentpriorityhistory`
--

LOCK TABLES `agentpriorityhistory` WRITE;
/*!40000 ALTER TABLE `agentpriorityhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `agentpriorityhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agenttype`
--

DROP TABLE IF EXISTS `agenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenttype` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenttype`
--

LOCK TABLES `agenttype` WRITE;
/*!40000 ALTER TABLE `agenttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CountInPack` int NOT NULL,
  `Unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CountInStock` double DEFAULT NULL,
  `MinCount` double NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Cost` decimal(10,2) NOT NULL,
  `Image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MaterialType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Вата серый 1x1',7,'м',191,34,NULL,6009.00,NULL,'Вата'),(2,'Ткань белый 2x2',10,'м',713,18,NULL,13742.00,NULL,'Ткань'),(3,'Металлический стержень белый 0x2',9,'кг',280,12,NULL,10633.00,NULL,'Стержень'),(4,'Силикон серый 1x1',2,'м',981,12,NULL,2343.00,NULL,'Силикон'),(5,'Силикон белый 0x3',8,'кг',307,17,NULL,12097.00,NULL,'Силикон'),(6,'Силикон белый 1x3',4,'кг',345,46,NULL,13550.00,NULL,'Силикон'),(7,'Ткань серый 0x3',10,'м',965,17,NULL,15210.00,NULL,'Ткань'),(8,'Резинка зеленый 1x0',8,'кг',256,9,NULL,32616.00,NULL,'Резинка'),(9,'Металлический стержень белый 2x2',9,'м',65,36,NULL,36753.00,NULL,'Стержень'),(10,'Ткань синий 3x3',5,'м',387,39,NULL,32910.00,NULL,'Ткань'),(11,'Ткань белый 3x2',9,'м',398,25,NULL,782.00,NULL,'Ткань'),(12,'Вата розовый 1x0',3,'м',589,32,NULL,35776.00,NULL,'Вата'),(13,'Вата серый 3x2',5,'кг',471,40,NULL,20453.00,NULL,'Вата'),(14,'Ткань розовый 0x0',3,'м',654,29,NULL,41101.00,NULL,'Ткань'),(15,'Металлический стержень цветной 3x1',4,'м',988,49,NULL,55742.00,NULL,'Стержень'),(16,'Резинка синий 1x0',3,'кг',191,11,NULL,1407.00,NULL,'Резинка'),(17,'Металлический стержень цветной 1x2',8,'м',173,26,NULL,26137.00,NULL,'Стержень'),(18,'Ткань цветной 2x1',2,'м',993,34,NULL,15628.00,NULL,'Ткань'),(19,'Силикон белый 2x0',10,'м',851,38,NULL,22538.00,NULL,'Силикон'),(20,'Силикон зеленый 3x1',2,'м',776,46,NULL,17312.00,NULL,'Силикон'),(21,'Вата розовый 3x1',3,'кг',246,41,NULL,44015.00,NULL,'Вата'),(22,'Ткань синий 0x2',8,'кг',841,21,NULL,27338.00,NULL,'Ткань'),(23,'Вата серый 3x3',1,'кг',237,12,NULL,19528.00,NULL,'Вата'),(24,'Вата белый 2x0',8,'кг',983,49,NULL,38432.00,NULL,'Вата'),(25,'Ткань синий 2x0',4,'м',146,16,NULL,19507.00,NULL,'Ткань'),(26,'Металлический стержень зеленый 2x2',4,'м',478,34,NULL,32205.00,NULL,'Стержень'),(27,'Резинка зеленый 0x0',7,'м',594,19,NULL,42640.00,NULL,'Резинка'),(28,'Ткань зеленый 2x2',4,'м',692,7,NULL,55083.00,NULL,'Ткань'),(29,'Металлический стержень синий 0x1',9,'м',259,20,NULL,19715.00,NULL,'Стержень'),(30,'Резинка белый 3x3',1,'м',586,26,NULL,35230.00,NULL,'Резинка'),(31,'Резинка зеленый 3x0',10,'кг',976,40,NULL,41227.00,NULL,'Резинка'),(32,'Ткань белый 1x3',8,'м',492,9,NULL,38232.00,NULL,'Ткань'),(33,'Силикон цветной 1x0',10,'м',843,28,NULL,34664.00,NULL,'Силикон'),(34,'Силикон зеленый 0x3',9,'кг',124,35,NULL,24117.00,NULL,'Силикон'),(35,'Вата серый 0x1',8,'м',25,38,NULL,42948.00,NULL,'Вата'),(36,'Металлический стержень белый 3x1',9,'м',749,30,NULL,9.00,NULL,'Стержень'),(37,'Резинка синий 3x1',4,'кг',232,36,NULL,36016.00,NULL,'Резинка'),(38,'Металлический стержень синий 3x1',6,'м',336,24,NULL,26976.00,NULL,'Стержень'),(39,'Силикон белый 1x2',2,'м',793,30,NULL,33801.00,NULL,'Силикон'),(40,'Резинка цветной 1x1',8,'м',347,13,NULL,26244.00,NULL,'Резинка'),(41,'Силикон розовый 1x3',9,'м',997,25,NULL,33874.00,NULL,'Силикон'),(42,'Резинка синий 3x2',5,'м',284,31,NULL,44031.00,NULL,'Резинка'),(43,'Резинка розовый 1x0',1,'м',265,21,NULL,36574.00,NULL,'Резинка'),(44,'Резинка зеленый 0x3',8,'кг',856,17,NULL,45349.00,NULL,'Резинка'),(45,'Резинка цветной 0x1',8,'м',290,32,NULL,47198.00,NULL,'Резинка'),(46,'Вата розовый 3x3',10,'м',536,31,NULL,2517.00,NULL,'Вата'),(47,'Резинка цветной 0x2',10,'м',189,31,NULL,55495.00,NULL,'Резинка'),(48,'Вата серый 3x0',8,'кг',48,32,NULL,49181.00,NULL,'Вата'),(49,'Резинка серый 3x3',4,'м',373,8,NULL,51550.00,NULL,'Резинка'),(50,'Резинка серый 0x0',7,'м',395,20,NULL,43414.00,NULL,'Резинка');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialcounthistory`
--

DROP TABLE IF EXISTS `materialcounthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialcounthistory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MaterialID` int NOT NULL,
  `ChangeDate` datetime(6) NOT NULL,
  `CountValue` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MaterialCountHistory_Material` (`MaterialID`),
  CONSTRAINT `FK_MaterialCountHistory_Material` FOREIGN KEY (`MaterialID`) REFERENCES `material` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialcounthistory`
--

LOCK TABLES `materialcounthistory` WRITE;
/*!40000 ALTER TABLE `materialcounthistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `materialcounthistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialsupplier`
--

DROP TABLE IF EXISTS `materialsupplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialsupplier` (
  `MaterialID` int NOT NULL,
  `SupplierID` int NOT NULL,
  PRIMARY KEY (`MaterialID`,`SupplierID`),
  KEY `FK_MaterialSupplier_Supplier` (`SupplierID`),
  CONSTRAINT `FK_MaterialSupplier_Material` FOREIGN KEY (`MaterialID`) REFERENCES `material` (`ID`),
  CONSTRAINT `FK_MaterialSupplier_Supplier` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialsupplier`
--

LOCK TABLES `materialsupplier` WRITE;
/*!40000 ALTER TABLE `materialsupplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `materialsupplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialtype`
--

DROP TABLE IF EXISTS `materialtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialtype` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DefectedPercent` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialtype`
--

LOCK TABLES `materialtype` WRITE;
/*!40000 ALTER TABLE `materialtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `materialtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ProductType` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ArticleNumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ProductionPersonCount` int DEFAULT NULL,
  `ProductionWorkshopNumber` int DEFAULT NULL,
  `MinCostForAgent` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Полумаска Moon (Элипс) P3','Полумаски','59922',NULL,'продукты/5fb128cd1e2b9.jpg',5,4,2690.00),(2,'Повязка санитарно–гигиеническая многоразовая с логотипом СОЮЗСПЕЦОДЕЖДА','Повязки','5028556',NULL,'не указано',5,9,49.00),(3,'Повязка санитарно–гигиеническая многоразовая черная','Повязки','5028272',NULL,'отсутствует',4,4,59.00),(4,'Маска одноразовая трехслойная из нетканого материала нестерильная','Повязки','5028247',NULL,'продукты/5fb128cc69235.jpg',3,2,6.00),(5,'Повязка санитарно–гигиеническая многоразовая с принтом','Повязки','5028229',NULL,'отсутствует',2,10,49.00),(6,'Маска из нетканого материала KN95','Маски','5030981',NULL,'продукты/5fb128cc719a6.jpg',3,5,59.00),(7,'Маска из нетканого материала с клапаном KN95','Маски','5029784',NULL,'продукты/5fb128cc753e3.jpg',3,4,79.00),(8,'Респиратор У-2К','Маски','58953',NULL,'продукты/5fb128cc7941f.jpg',2,6,95.00),(9,'Респиратор 9101 FFP1','Респираторы','5026662',NULL,'продукты/5fb128cc7d798.jpg',5,8,189.00),(10,'Респиратор противоаэрозольный 9312','Респираторы','59043',NULL,'продукты/5fb128cc80a10.jpg',4,7,399.00),(11,'Респиратор 3M 8112 противоаэрозольный с клапаном выдоха','Респираторы','58376',NULL,'продукты/5fb128cc84474.jpg',3,1,299.00),(12,'Респиратор 3M 8101 противоаэрозольный','Респираторы','58375',NULL,'продукты/5fb128cc87b90.jpg',1,4,149.00),(13,'Респиратор Алина 110','Респираторы','59324',NULL,'продукты/5fb128cc8b750.jpg',3,9,129.00),(14,'Респиратор Алина 100','Респираторы','58827',NULL,'продукты/5fb128cc8f4dd.jpg',2,8,99.00),(15,'Респиратор Нева 109','Респираторы','59898',NULL,'продукты/5fb128cc9414b.jpg',4,1,129.00),(16,'Респиратор Юлия 109','Респираторы','59474',NULL,'продукты/5fb128cc97ff4.jpg',4,8,129.00),(17,'Респиратор Юлия 119','Респираторы','59472',NULL,'продукты/5fb128cc9bd36.jpg',3,7,149.00),(18,'Респиратор 3M с клапаном 9162','Респираторы','5033136',NULL,'продукты/5fb128cc9f069.jpg',2,9,349.00),(19,'Респиратор 3M 9152 FFP2','Респираторы','5028048',NULL,'продукты/5fb128cca31d9.jpg',2,8,390.00),(20,'Респиратор противоаэрозольный 9322','Респираторы','58796',NULL,'продукты/5fb128cca6910.jpg',4,4,449.00),(21,'Респиратор с клапаном 9926','Респираторы','58568',NULL,'продукты/5fb128cca9d9b.jpg',3,5,699.00),(22,'Респиратор 3M 8102 противоаэрозольный','Респираторы','58466',NULL,'продукты/5fb128ccae21a.jpg',3,9,199.00),(23,'Респиратор 3M 8122','Респираторы','58445',NULL,'продукты/5fb128ccb1958.jpg',3,6,299.00),(24,'Респиратор M1200VWC FFP2 Delta Plus (Дельта Плюс)','Респираторы','5031919',NULL,'продукты/5fb128ccb4e8c.jpg',2,8,349.00),(25,'Респиратор RK6021','Респираторы','5030026',NULL,'продукты/5fb128ccb97a0.jpg',5,8,290.00),(26,'Респиратор RK6020','Респираторы','5030020',NULL,'продукты/5fb128ccbd227.jpg',3,5,129.00),(27,'Респиратор Алина 210','Респираторы','5030072',NULL,'продукты/5fb128ccc1592.jpg',1,5,290.00),(28,'Респиратор Алина 211','Респираторы','5030062',NULL,'продукты/5fb128ccc4a86.jpg',1,6,290.00),(29,'Респиратор Алина 200','Респираторы','58826',NULL,'продукты/5fb128ccc9a9e.jpg',4,5,149.00),(30,'Респиратор Алина П','Респираторы','58825',NULL,'продукты/5fb128cccdbee.jpg',4,5,290.00),(31,'Респиратор Алина АВ','Респираторы','58584',NULL,'продукты/5fb128ccd133c.jpg',2,5,249.00),(32,'Респиратор Нева 210','Респираторы','59736',NULL,'продукты/5fb128ccd5dc2.jpg',1,3,109.00),(33,'Респиратор Нева 200','Респираторы','59735',NULL,'продукты/5fb128ccd8ff6.jpg',2,3,79.00),(34,'Респиратор полумаска НРЗ-0102 FFP2 NR D','Респираторы','5027238',NULL,'продукты/5fb128ccdca1e.jpg',4,4,149.00),(35,'Респиратор Юлия 219','Респираторы','59475',NULL,'продукты/5fb128cce0042.jpg',4,8,249.00),(36,'Респиратор Юлия 215','Респираторы','59473',NULL,'продукты/5fb128cce39fa.jpg',3,4,349.00),(37,'Респиратор Юлия 209','Респираторы','59470',NULL,'продукты/5fb128cce7971.jpg',2,8,179.00),(38,'Респиратор M1300V2С FFP3 Delta Plus (Дельта Плюс)','Респираторы','5031924',NULL,'продукты/5fb128cceae7c.jpg',5,2,490.00),(39,'Респиратор RK6030','Респираторы','5030022',NULL,'продукты/5fb128ccef256.jpg',3,6,390.00),(40,'Респиратор Алина 310','Респираторы','58850',NULL,'продукты/5fb128ccf3dd2.jpg',5,6,490.00),(41,'Респиратор Нева 310','Респираторы','59739',NULL,'продукты/5fb128cd0544b.jpg',4,3,289.00),(42,'Респиратор Юлия 319','Респираторы','59471',NULL,'продукты/5fb128cd08e3f.jpg',4,8,490.00),(43,'Полумаска Elipse (Элипс) ABEK1P3','Респираторы','5027980',NULL,'продукты/5fb128cd0d0b1.jpg',2,1,4990.00),(44,'Полумаска Elipse (Элипс) A2P3','Полумаски','5027965',NULL,'продукты/5fb128cd10ec2.jpg',4,2,4490.00),(45,'Полумаска Elipse (Элипс) А1','Полумаски','5027958',NULL,'продукты/5fb128cd157f9.jpg',2,4,3190.00),(46,'Полумаска Elipse (Элипс) P3 (анти-запах)','Полумаски','59923',NULL,'продукты/5fb128cd19baa.jpg',1,9,2790.00),(47,'Полумаска Elipse (Элипс) P3','Полумаски','59922',NULL,'продукты/5fb128cd1e2b9.jpg',5,4,2690.00),(48,'Полумаска Elipse (Элипс) A1P3','Полумаски','59921',NULL,'продукты/5fb128cd2215f.jpg',3,9,5690.00),(49,'Полумаска Elipse (Элипс) ABEK1','Полумаски','59920',NULL,'продукты/5fb128cd268bf.jpg',2,8,5690.00),(50,'Респиратор-полумаска 3М серия 6000','Полумаски','58974',NULL,'продукты/5fb128cd2ab69.jpg',5,9,3490.00),(51,'Респиратор-полумаска Исток 300/400','Полумаски','59334',NULL,'продукты/5fb128cd2ef7a.jpg',4,7,490.00),(52,'Комплект для защиты дыхания J-SET 6500 JETA','Полумаски','4969295',NULL,'продукты/5fb128cd331c4.jpg',4,4,2490.00),(53,'Лицевая маска Elipse Integra А1P3','Полумаски','5029610',NULL,'продукты/5fb128cd3674d.jpg',2,10,9890.00),(54,'Лицевая маска Elipse Integra P3','На лицо','5029091',NULL,'продукты/5fb128cd3af5c.jpg',5,9,7490.00),(55,'Лицевая маска Elipse Integra (Элипс интегра) P3 (анти-запах)','На лицо','60360',NULL,'продукты/5fb128cd3e7e4.jpg',2,4,7590.00),(56,'Полнолицевая маска 5950 JETA','На лицо','4958042',NULL,'продукты/5fb128cd41ece.jpg',1,5,11490.00),(57,'Сменный патрон с фильтром 6054 для масок и полумасок 3М серии 6000','Полнолицевые','59271',NULL,'продукты/5fb128cd4672c.jpg',4,2,1890.00),(58,'Сменный патрон с фильтром 6059 для масок и полумасок 3М серии 6000','Сменные части','59253',NULL,'продукты/5fb128cd4c99d.jpg',2,9,2290.00),(59,'Сменный фильтр 6510 A1 JETA','Сменные части','5028197',NULL,'продукты/5fb128cd50a70.jpg',5,9,990.00),(60,'Запасные фильтры к полумаске Elipse ABEK1P3','Сменные части','5027978',NULL,'продукты/5fb128cd5433e.jpg',3,6,2990.00),(61,'Запасные фильтры к полумаске Elipse A2P3','Запасные части','5027961',NULL,'продукты/5fb128cd5838d.jpg',2,9,2590.00),(62,'Запасные фильтры к полумаске Elipse (Элипс) А1','Запасные части','5027921',NULL,'продукты/5fb128cd5bb7d.jpg',3,4,1290.00),(63,'Сменный фильтр 6541 ABEK1 JETA','Сменные части','4958040',NULL,'продукты/5fb128cd5ff78.jpg',4,6,1290.00),(64,'Запасные фильтры к полумаске Elipse (Элипс) P3 (анти-запах)','Запасные части','59919',NULL,'продукты/5fb128cd63666.jpg',4,4,1690.00),(65,'Запасные фильтры к полумаске Elipse (Элипс) P3','Запасные части','59918',NULL,'продукты/5fb128cd66df6.jpg',4,7,1390.00),(66,'Запасные фильтры к полумаске Elipse (Элипс) A1P3','Запасные части','59917',NULL,'продукты/5fb128cd6a2b6.jpg',1,3,2190.00),(67,'Запасные фильтры к полумаске Elipse (Элипс) ABEK1','Запасные части','59916',NULL,'продукты/5fb128cd6e4ee.jpg',3,10,2590.00),(68,'Запасные фильтры (пара) АВЕ1 к полумаскам Адвантейдж','Запасные части','59708',NULL,'продукты/5fb128cd71db3.jpg',2,3,1490.00),(69,'Запасной фильтр к полумаске Исток-300 (РПГ-67) марка В','Запасные части','67661',NULL,'продукты/5fb128cd7518c.jpg',5,9,110.00),(70,'Запасной фильтр к полумаске Исток-300 (РПГ-67) марка А','Запасные части','67660',NULL,'продукты/5fb128cd78fce.jpg',3,1,110.00),(71,'Держатель предфильтра 5101 JETA','Запасные части','4958041',NULL,'продукты/5fb128cd7d2cd.jpg',1,7,199.00),(72,'Держатели предфильтра для масок и полумасок 3М серии 6000','Держители','58431',NULL,'продукты/5fb128cd80a06.jpg',1,4,264.00),(73,'Предфильтр Р2 (4 шт) 6020 JETA','Держители','4958039',NULL,'продукты/5fb128cd8417e.jpg',1,7,380.00),(74,'Предфильтры для масок и полумасок 3М серии 6000','Предфильтры','58917',NULL,'продукты/5fb128cd8818d.jpg',5,3,409.00),(75,'Респиратор Мадонна 110','Респираторы','59324',NULL,'продукты/5fb128cc8b750.jpg',3,9,129.00),(76,'Респиратор Витязь 100','Респираторы','58827',NULL,'продукты/5fb128cc8f4dd.jpg',2,8,99.00),(77,'Респиратор Серёга 109','Респираторы','59898',NULL,'продукты/5fb128cc9414b.jpg',4,1,129.00),(78,'Респиратор Амперметр 109','Респираторы','59474',NULL,'продукты/5fb128cc97ff4.jpg',4,8,129.00),(79,'Респиратор Фирюза 110','Респираторы','59324',NULL,'продукты/5fb128cc8b750.jpg',3,9,129.00),(80,'Респиратор Красный 100','Респираторы','58827',NULL,'продукты/5fb128cc8f4dd.jpg',2,8,99.00),(81,'Респиратор Волга 109','Респираторы','59898',NULL,'продукты/5fb128cc9414b.jpg',4,1,129.00),(82,'Респиратор Мадонна 220','Респираторы','59474',NULL,'продукты/5fb128cc97ff4.jpg',4,8,129.00),(83,'Респиратор Витязь 220','Респираторы','59324',NULL,'продукты/5fb128cc8b750.jpg',3,9,129.00),(84,'Респиратор Серёга 220','Респираторы','58827',NULL,'продукты/5fb128cc8f4dd.jpg',2,8,99.00),(85,'Респиратор Амперметр 220','Респираторы','59898',NULL,'продукты/5fb128cc9414b.jpg',4,1,129.00),(86,'Респиратор Фирюза 220','Респираторы','59474',NULL,'продукты/5fb128cc97ff4.jpg',4,8,129.00),(87,'Респиратор Красный 220','Респираторы','59324',NULL,'продукты/5fb128cc8b750.jpg',3,9,129.00),(88,'Респиратор Волга 220','Респираторы','58827',NULL,'продукты/5fb128cc8f4dd.jpg',2,8,99.00),(89,'Полумаска Sunset ABEK1P3','Респираторы','5027980',NULL,'продукты/5fb128cd0d0b1.jpg',2,1,4990.00),(90,'Полумаска Sunset A2P3','Полумаски','5027965',NULL,'продукты/5fb128cd10ec2.jpg',4,2,4490.00),(91,'Полумаска Sunset А1','Полумаски','5027958',NULL,'продукты/5fb128cd157f9.jpg',2,4,3190.00),(92,'Полумаска Sunset P3 (анти-запах)','Полумаски','59923',NULL,'продукты/5fb128cd19baa.jpg',1,9,2790.00),(93,'Полумаска Sunset (Элипс) P3','Полумаски','59922',NULL,'продукты/5fb128cd1e2b9.jpg',5,4,2690.00),(94,'Полумаска Sunset A1P3','Полумаски','59921',NULL,'продукты/5fb128cd2215f.jpg',3,9,5690.00),(95,'Полумаска Sunset ABEK1','Полумаски','59920',NULL,'продукты/5fb128cd268bf.jpg',2,8,5690.00),(96,'Полумаска Moon ABEK1','Полумаски','59920',NULL,'продукты/5fb128cd268bf.jpg',2,8,5690.00),(97,'Полумаска Moon ABEK1P3','Респираторы','5027980',NULL,'продукты/5fb128cd0d0b1.jpg',2,1,4990.00),(98,'Полумаска Moon A2P3','Полумаски','5027965',NULL,'продукты/5fb128cd10ec2.jpg',4,2,4490.00),(99,'Полумаска Moon А1','Полумаски','5027958',NULL,'продукты/5fb128cd157f9.jpg',2,4,3190.00),(100,'Полумаска Moon P3 (анти-запах)','Полумаски','59923',NULL,'продукты/5fb128cd19baa.jpg',1,9,2790.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcosthistory`
--

DROP TABLE IF EXISTS `productcosthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcosthistory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `ChangeDate` datetime(6) NOT NULL,
  `CostValue` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ProductCostHistory_Product` (`ProductID`),
  CONSTRAINT `FK_ProductCostHistory_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcosthistory`
--

LOCK TABLES `productcosthistory` WRITE;
/*!40000 ALTER TABLE `productcosthistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcosthistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmaterial`
--

DROP TABLE IF EXISTS `productmaterial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productmaterial` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `MaterialID` int NOT NULL,
  `Count` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ProductMaterial_Material` (`MaterialID`),
  KEY `FK_ProductMaterial_Product` (`ProductID`),
  CONSTRAINT `FK_ProductMaterial_Material` FOREIGN KEY (`MaterialID`) REFERENCES `material` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_ProductMaterial_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmaterial`
--

LOCK TABLES `productmaterial` WRITE;
/*!40000 ALTER TABLE `productmaterial` DISABLE KEYS */;
INSERT INTO `productmaterial` VALUES (1,1,41,10),(2,1,3,12),(3,2,35,5),(4,2,15,16),(5,3,31,2),(6,3,3,9),(7,3,45,11),(8,3,14,18),(9,5,7,7),(10,5,24,11),(11,5,28,14),(12,5,14,18),(13,5,20,4),(14,6,31,19),(15,6,20,5),(16,6,43,15),(17,6,23,2),(18,8,27,19),(19,9,32,9),(20,9,45,14),(21,10,7,8),(22,10,29,9),(23,10,44,20),(24,10,21,2),(25,11,42,20),(26,12,47,3),(27,12,17,1),(28,12,6,3),(29,13,34,9),(30,13,26,1),(31,15,7,4),(32,15,9,19),(33,16,32,8),(34,16,22,18),(35,17,11,3),(36,18,48,11),(37,20,41,4),(38,21,49,19),(39,22,2,12),(40,22,11,14),(41,22,37,4),(42,23,33,4),(43,23,36,2),(44,23,38,15),(45,23,12,12),(46,24,29,5),(47,24,27,5),(48,24,6,19),(49,25,36,7),(50,25,6,10),(51,25,14,9),(52,26,7,10),(53,27,29,4),(54,28,1,19),(55,29,36,16),(56,29,16,4),(57,29,30,19),(58,30,36,18),(59,30,22,1),(60,30,21,13),(61,30,23,9),(62,31,14,20),(63,31,43,9),(64,32,38,2),(65,33,6,13),(66,33,16,19),(67,35,47,2),(68,35,50,17),(69,35,15,2),(70,36,3,19),(71,36,11,1),(72,36,8,1),(73,37,29,6),(74,37,16,6),(75,37,4,15),(76,38,3,10),(77,38,13,13),(78,38,49,3),(79,39,31,1),(80,39,7,20),(81,40,2,8),(82,40,42,19),(83,41,31,16),(84,41,19,17),(85,42,20,12),(86,43,37,17),(87,44,29,9),(88,44,25,19),(89,44,14,2),(90,45,45,20),(91,46,23,18),(92,48,46,3),(93,48,33,16),(94,48,22,16),(95,49,35,2),(96,49,6,15),(97,49,20,13),(98,50,50,17);
/*!40000 ALTER TABLE `productmaterial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsale`
--

DROP TABLE IF EXISTS `productsale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productsale` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AgentID` int NOT NULL,
  `ProductID` int NOT NULL,
  `SaleDate` date NOT NULL,
  `ProductCount` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ProductSale_Agent` (`AgentID`),
  KEY `FK_ProductSale_Product` (`ProductID`),
  CONSTRAINT `FK_ProductSale_Agent` FOREIGN KEY (`AgentID`) REFERENCES `agent` (`ID`),
  CONSTRAINT `FK_ProductSale_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsale`
--

LOCK TABLES `productsale` WRITE;
/*!40000 ALTER TABLE `productsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttype`
--

DROP TABLE IF EXISTS `producttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producttype` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DefectedPercent` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttype`
--

LOCK TABLES `producttype` WRITE;
/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Address` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `AgentID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Shop_Agent` (`AgentID`),
  CONSTRAINT `FK_Shop_Agent` FOREIGN KEY (`AgentID`) REFERENCES `agent` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `INN` varchar(12) NOT NULL,
  `StartDate` date NOT NULL,
  `QualityRating` int DEFAULT NULL,
  `SupplierType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp` (
  `product_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `material_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `need_count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
INSERT INTO `temp` VALUES ('Респиратор Алина АВ','Резинка розовый 1x0',9),('Респиратор Алина 200','Резинка белый 3x3',19),('Маска одноразовая трехслойная из нетканого материала, нестерильная','Резинка белый 3x3',19),('Полумаска Elipse (Элипс) P3 (анти-запах)','Вата серый 3x3',18),('Маска из нетканого материала KN95','Вата серый 3x3',2),('Маска из нетканого материала KN95','Резинка розовый 1x0',15),('Респиратор Алина П','Вата серый 3x3',9),('Повязка санитарно–гигиеническая многоразовая с принтом','Силикон зеленый 3x1',4),('Полумаска Elipse (Элипс) ABEK1','Силикон зеленый 3x1',13),('Маска из нетканого материала KN95','Силикон зеленый 3x1',5),('Респиратор Юлия 319','Силикон зеленый 3x1',12),('Респиратор Юлия 209','Силикон серый 1x1',15),('Респиратор противоаэрозольный 9312','Вата розовый 3x1',2),('Респиратор 3M 8122','Вата розовый 1x0',12),('Респиратор Нева 200','Резинка синий 1x0',19),('Повязка санитарно–гигиеническая многоразовая черная','Ткань розовый 0x0',18),('Респиратор Алина АВ','Ткань розовый 0x0',20),('Респиратор RK6021','Ткань розовый 0x0',9),('Повязка санитарно–гигиеническая многоразовая с принтом','Ткань розовый 0x0',18),('Респиратор Алина 200','Резинка синий 1x0',4),('Полумаска Elipse (Элипс) A2P3','Ткань розовый 0x0',2),('Респиратор Алина П','Вата розовый 3x1',13),('Респиратор Юлия 209','Резинка синий 1x0',6),('Респиратор M1200VWC FFP2 Delta Plus (Дельта Плюс)','Силикон белый 1x3',19),('Повязка санитарно–гигиеническая многоразовая с логотипом СОЮЗСПЕЦОДЕЖДА','Металлический стержень цветной 3x1',16),('Полумаска Elipse (Элипс) A2P3','Ткань синий 2x0',19),('Респиратор 3M 8102 противоаэрозольный','Резинка синий 3x1',4),('Полумаска Elipse (Элипс) ABEK1','Силикон белый 1x3',15),('Полумаска Elipse (Элипс) ABEK1P3','Резинка синий 3x1',17),('Респиратор 3M 8101 противоаэрозольный','Силикон белый 1x3',3),('Респиратор Алина 110','Металлический стержень зеленый 2x2',1),('Повязка санитарно–гигиеническая многоразовая с принтом','Ткань зеленый 2x2',14),('Респиратор RK6021','Силикон белый 1x3',10),('Респиратор с клапаном 9926','Резинка серый 3x3',19),('Респиратор Нева 200','Силикон белый 1x3',13),('Респиратор Юлия 219','Металлический стержень цветной 3x1',2),('Респиратор M1300V2С FFP3 Delta Plus (Дельта Плюс)','Резинка серый 3x3',3),('Респиратор 3M 8112 противоаэрозольный с клапаном выдоха','Резинка синий 3x2',20),('Респиратор M1300V2С FFP3 Delta Plus (Дельта Плюс)','Вата серый 3x2',13),('Респиратор Алина 310','Резинка синий 3x2',19),('Респиратор Нева 210','Металлический стержень синий 3x1',2),('Респиратор 3M 8122','Металлический стержень синий 3x1',15),('Респиратор M1200VWC FFP2 Delta Plus (Дельта Плюс)','Резинка зеленый 0x0',5),('Респиратор Алина 211','Вата серый 1x1',19),('Респиратор Юлия 219','Резинка серый 0x0',17),('Респиратор У-2К','Резинка зеленый 0x0',19),('Респиратор-полумаска 3М серия 6000','Резинка серый 0x0',17),('Повязка санитарно–гигиеническая многоразовая с логотипом СОЮЗСПЕЦОДЕЖДА','Вата серый 0x1',5),('Маска одноразовая трехслойная из нетканого материала, нестерильная','Резинка зеленый 1x0',20),('Респиратор Юлия 109','Ткань синий 0x2',18),('Респиратор противоаэрозольный 9312','Резинка зеленый 0x3',20),('Респиратор Юлия 109','Ткань белый 1x3',8),('Респиратор Юлия 215','Резинка зеленый 1x0',1),('Респиратор 9101 FFP1','Резинка цветной 0x1',14),('Респиратор 9101 FFP1','Ткань белый 1x3',9),('Повязка санитарно–гигиеническая многоразовая черная','Резинка цветной 0x1',11),('Респиратор 3M с клапаном 9162','Вата серый 3x0',11),('Полумаска Elipse (Элипс) А1','Резинка цветной 0x1',20),('Повязка санитарно–гигиеническая многоразовая с принтом','Вата белый 2x0',11),('Полумаска Elipse (Элипс) A1P3','Ткань синий 0x2',16),('Респиратор 3M 8101 противоаэрозольный','Металлический стержень цветной 1x2',1),('Респиратор Алина П','Ткань синий 0x2',1),('Полумаска Elipse (Элипс) ABEK1','Вата серый 0x1',2),('Респиратор Юлия 215','Ткань белый 3x2',1),('Респиратор 3M 8122','Металлический стержень белый 3x1',2),('Респиратор M1200VWC FFP2 Delta Plus (Дельта Плюс)','Металлический стержень синий 0x1',5),('Респиратор Юлия 209','Металлический стержень синий 0x1',6),('Респиратор M1300V2С FFP3 Delta Plus (Дельта Плюс)','Металлический стержень белый 0x2',10),('Полумаска Moon (Элипс) P3','Металлический стержень белый 0x2',12),('Респиратор RK6021','Металлический стержень белый 3x1',7),('Респиратор Алина 210','Металлический стержень синий 0x1',4),('Респиратор Алина 200','Металлический стержень белый 3x1',16),('Респиратор противоаэрозольный 9322','Силикон розовый 1x3',4),('Респиратор Алина П','Металлический стержень белый 3x1',18),('Полумаска Moon (Элипс) P3','Силикон розовый 1x3',10),('Полумаска Elipse (Элипс) A2P3','Металлический стержень синий 0x1',9),('Повязка санитарно–гигиеническая многоразовая черная','Металлический стержень белый 0x2',9),('Респиратор противоаэрозольный 9312','Металлический стержень синий 0x1',9),('Респиратор Алина 110','Силикон зеленый 0x3',9),('Респиратор Нева 109','Металлический стержень белый 2x2',19),('Респиратор Юлия 119','Ткань белый 3x2',3),('Респиратор Юлия 215','Металлический стержень белый 0x2',19),('Респиратор 3M 8102 противоаэрозольный','Ткань белый 3x2',14),('Маска из нетканого материала KN95','Резинка зеленый 3x0',19),('Респиратор Нева 310','Силикон белый 2x0',17),('Респиратор Нева 310','Резинка зеленый 3x0',16),('Повязка санитарно–гигиеническая многоразовая с принтом','Ткань серый 0x3',7),('Респиратор 3M 8122','Силикон цветной 1x0',4),('Повязка санитарно–гигиеническая многоразовая черная','Резинка зеленый 3x0',2),('Респиратор 3M 8102 противоаэрозольный','Ткань белый 2x2',12),('Респиратор Нева 109','Ткань серый 0x3',4),('Респиратор 3M 8101 противоаэрозольный','Резинка цветной 0x2',3),('Респиратор RK6020','Ткань серый 0x3',10),('Респиратор противоаэрозольный 9312','Ткань серый 0x3',8),('Полумаска Elipse (Элипс) A1P3','Силикон цветной 1x0',16),('Полумаска Elipse (Элипс) A1P3','Вата розовый 3x3',3),('Респиратор Юлия 219','Резинка цветной 0x2',2),('Респиратор RK6030','Ткань серый 0x3',20),('Респиратор RK6030','Резинка зеленый 3x0',1),('Респиратор Алина 310','Ткань белый 2x2',8);
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'demoexam3'
--

--
-- Dumping routines for database 'demoexam3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-24 12:58:21
