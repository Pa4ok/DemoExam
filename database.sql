CREATE DATABASE  IF NOT EXISTS `demoexam4` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demoexam4`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: demoexam4
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
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Резина 1x3',3,'м',77,44,NULL,8334.00,'\\materials\\material_15.jpeg','Резина'),(2,'Краска 2x3',8,'л',414,33,NULL,24447.00,'\\materials\\material_16.jpeg','Краска'),(3,'Резина 3x3',8,'кг',727,46,NULL,42751.00,'','Резина'),(4,'Краска 1x4',9,'кг',576,7,NULL,52716.00,'','Краска'),(5,'Резина 1x37',8,'кг',110,47,NULL,1053.00,'','Резина'),(6,'Резина 2x0',3,'м',129,11,NULL,46084.00,'','Резина'),(7,'Резина 1x14',5,'м',7,9,NULL,17063.00,'','Резина'),(8,'Силикон 3x33',7,'м',687,45,NULL,54740.00,'','Силикон'),(9,'Резина 3x22',6,'кг',672,14,NULL,27626.00,'','Резина'),(10,'Резина 2x1',10,'м',886,7,NULL,36226.00,'\\materials\\material_13.jpeg','Резина'),(11,'Краска 1x2',9,'л',801,28,NULL,48813.00,'','Краска'),(12,'Резина 2x3',9,'м',50,11,NULL,52328.00,'','Резина'),(13,'Силикон 1x27',8,'кг',950,14,NULL,6286.00,'','Силикон'),(14,'Краска 3x14',5,'л',34,13,NULL,38060.00,'\\materials\\material_8.jpeg','Краска'),(15,'Краска 2x5',9,'кг',542,32,NULL,29855.00,'','Краска'),(16,'Силикон 3x15',7,'кг',856,17,NULL,40057.00,'\\materials\\material_14.jpeg','Силикон'),(17,'Силикон 3x39',9,'м',858,8,NULL,31438.00,'','Силикон'),(18,'Силикон 1x2',7,'кг',469,50,NULL,24120.00,'\\materials\\material_19.jpeg','Силикон'),(19,'Силикон 3x28',7,'м',92,47,NULL,37171.00,'','Силикон'),(20,'Силикон 0x18',2,'кг',631,8,NULL,15243.00,'','Силикон'),(21,'Силикон 0x0',5,'кг',929,37,NULL,17974.00,'','Силикон'),(22,'Краска 3x31',3,'л',365,32,NULL,30698.00,'','Краска'),(23,'Резина 1x5',2,'м',481,11,NULL,42602.00,'','Резина'),(24,'Силикон 0x12',6,'кг',610,12,NULL,5588.00,'','Силикон'),(25,'Силикон 3x2',8,'кг',863,32,NULL,55673.00,'\\materials\\material_20.jpeg','Силикон'),(26,'Резина 1x9',10,'м',587,48,NULL,10774.00,'','Резина'),(27,'Краска 3x35',4,'кг',479,31,NULL,6825.00,'','Краска'),(28,'Краска 2x31',1,'кг',771,14,NULL,32610.00,'','Краска'),(29,'Резина 3x25',6,'м',199,5,NULL,9652.00,'','Резина'),(30,'Краска 4x0',9,'л',713,22,NULL,55038.00,'\\materials\\material_9.jpeg','Краска'),(31,'Краска 2x4',10,'л',761,49,NULL,35636.00,'\\materials\\material_6.jpeg','Краска'),(32,'Резина 1x0',10,'м',459,22,NULL,469.00,'','Резина'),(33,'Краска 3x2',10,'л',922,35,NULL,44456.00,'','Краска'),(34,'Краска 3x0',7,'л',921,20,NULL,41707.00,'','Краска'),(35,'Краска 2x29',7,'кг',465,30,NULL,37812.00,'','Краска'),(36,'Силикон 3x14',7,'м',324,19,NULL,38935.00,'','Силикон'),(37,'Силикон 3x3',10,'м',870,6,NULL,2870.00,'','Силикон'),(38,'Силикон 3x18',5,'м',978,24,NULL,40196.00,'','Силикон'),(39,'Резина 3x37',10,'м',870,43,NULL,18158.00,'','Резина'),(40,'Краска 0x4',10,'кг',3,45,NULL,31475.00,'\\materials\\material_7.jpeg','Краска'),(41,'Краска 2x1',4,'л',2,5,NULL,48799.00,'\\materials\\material_2.jpeg','Краска'),(42,'Резина 0x0',8,'кг',897,20,NULL,18283.00,'','Резина'),(43,'Краска 4x3',2,'л',218,27,NULL,42215.00,'','Краска'),(44,'Резина 11x0',5,'м',402,17,NULL,39297.00,'','Резина'),(45,'Резина 0x2',9,'кг',577,38,NULL,46929.00,'','Резина'),(46,'Краска 0x5',7,'л',559,50,NULL,36762.00,'','Краска'),(47,'Резина 3x2',4,'м',131,31,NULL,12723.00,'','Резина'),(48,'Силикон 1x22',7,'м',649,48,NULL,31182.00,'','Силикон'),(49,'Краска 2x0',3,'л',595,27,NULL,28464.00,'\\materials\\material_1.jpeg','Краска'),(50,'Краска 0x2',9,'л',235,15,NULL,20629.00,'','Краска'),(51,'Силикон 2x2',8,'м',46,42,NULL,42856.00,'\\materials\\material_3.jpeg','Силикон'),(52,'Резина 0x13',6,'кг',376,48,NULL,54301.00,'','Резина'),(53,'Резина 0x78',3,'кг',593,48,NULL,38768.00,'','Резина'),(54,'Краска 2x2',2,'л',787,16,NULL,45084.00,'\\materials\\material_21.jpeg','Краска'),(55,'Силикон 0x2',2,'м',669,43,NULL,9098.00,'','Силикон'),(56,'Резина 0x10',3,'кг',354,22,NULL,47481.00,'','Резина'),(57,'Резина 3x23',7,'кг',167,45,NULL,23578.00,'','Резина'),(58,'Резина 2x35',7,'м',271,13,NULL,30798.00,'','Резина'),(59,'Силикон 0x3',1,'м',117,21,NULL,4589.00,'','Силикон'),(60,'Резина 2x2',3,'м',851,7,NULL,44820.00,'','Резина'),(61,'Краска 0x3',2,'кг',646,5,NULL,8487.00,'','Краска'),(62,'Резина 0x12',1,'кг',380,13,NULL,14110.00,'\\materials\\material_4.jpeg','Резина'),(63,'Краска 3x27',3,'кг',568,37,NULL,14606.00,'','Краска'),(64,'Резина 2x27',6,'м',434,32,NULL,47429.00,'','Резина'),(65,'Силикон 0x28',8,'м',144,34,NULL,43526.00,'','Силикон'),(66,'Резина 1x1',2,'м',244,43,NULL,8906.00,'','Резина'),(67,'Резина 0x30',1,'м',143,48,NULL,21180.00,'','Резина'),(68,'Силикон 0x23',9,'м',753,10,NULL,9412.00,'','Силикон'),(69,'Силикон 2x13',3,'м',423,5,NULL,19429.00,'','Силикон'),(70,'Резина 0x3',6,'м',340,16,NULL,11310.00,'','Резина'),(71,'Краска 4x04',9,'кг',657,25,NULL,54177.00,'','Краска'),(72,'Резина 1x32',9,'м',709,45,NULL,36799.00,'','Резина'),(73,'Силикон 1x1',1,'кг',110,10,NULL,10649.00,'','Силикон'),(74,'Резина 3x1',6,'м',713,27,NULL,24002.00,'','Резина'),(75,'Резина 0x65',1,'м',133,34,NULL,9263.00,'','Резина'),(76,'Силикон 0x11',9,'м',465,11,NULL,34946.00,'','Силикон'),(77,'Краска 0x0',8,'л',318,28,NULL,35754.00,'','Краска'),(78,'Краска 2x24',2,'кг',797,23,NULL,26008.00,'\\materials\\material_22.jpeg','Краска'),(79,'Краска 0x1',7,'л',228,14,NULL,13666.00,'','Краска'),(80,'Резина 3x38',10,'м',892,9,NULL,11039.00,'\\materials\\material_17.jpeg','Резина'),(81,'Резина 3x28',8,'кг',395,43,NULL,54007.00,'','Резина'),(82,'Краска 3x18',10,'л',128,5,NULL,20504.00,'\\materials\\material_10.jpeg','Краска'),(83,'Силикон 0x1',3,'кг',401,9,NULL,29767.00,'','Силикон'),(84,'Краска 1x0',5,'кг',12,49,NULL,51511.00,'\\materials\\material_18.jpeg','Краска'),(85,'Краска 3x1',3,'кг',729,21,NULL,10299.00,'','Краска'),(86,'Силикон 3x0',9,'кг',901,48,NULL,23681.00,'\\materials\\material_5.jpeg','Силикон'),(87,'Силикон 3x35',2,'м',610,32,NULL,3326.00,'','Силикон'),(88,'Краска 1x1',2,'л',281,20,NULL,19485.00,'\\materials\\material_11.jpeg','Краска'),(89,'Силикон 2x17',1,'кг',409,16,NULL,12158.00,'','Силикон'),(90,'Резина 0x1',3,'м',986,18,NULL,24135.00,'','Резина'),(91,'Силикон 3x1',9,'м',16,17,NULL,33602.00,'\\materials\\material_12.jpeg','Силикон'),(92,'Силикон 2x1',6,'м',461,13,NULL,19352.00,'','Силикон'),(93,'Резина 0x37',9,'м',764,26,NULL,33541.00,'','Резина'),(95,'Краска 5x0',10,'л',844,24,NULL,43028.00,'','Краска'),(96,'Резина 3x34',4,'м',218,47,NULL,42162.00,'','Резина'),(97,'Краска 3x13',3,'л',851,6,NULL,41211.00,'','Краска'),(98,'Краска 3x4',5,'л',83,41,NULL,21211.00,'','Краска'),(99,'Краска 1x3',6,'л',91,50,NULL,46354.00,'','Краска'),(100,'Краска 2x28',4,'л',916,42,NULL,9273.00,'','Краска');
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
  `ID` int NOT NULL AUTO_INCREMENT,
  `MaterialID` int NOT NULL,
  `SupplierID` int NOT NULL,
  `ContractComment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MaterialSupplier_Supplier` (`SupplierID`),
  KEY `FK_MaterialSupplier_Material` (`MaterialID`),
  CONSTRAINT `FK_MaterialSupplier_Material` FOREIGN KEY (`MaterialID`) REFERENCES `material` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_MaterialSupplier_Supplier` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialsupplier`
--

LOCK TABLES `materialsupplier` WRITE;
/*!40000 ALTER TABLE `materialsupplier` DISABLE KEYS */;
INSERT INTO `materialsupplier` VALUES (1,1,11,''),(2,2,7,''),(3,2,22,''),(4,2,26,''),(5,3,29,''),(6,5,49,''),(7,5,33,''),(8,7,50,''),(9,7,20,''),(10,7,16,''),(11,10,6,'помогите меня держат в заложниках и я работаю за еду'),(12,10,1,''),(13,10,28,''),(14,10,19,''),(15,11,14,''),(16,11,10,''),(17,11,5,''),(18,14,20,''),(19,14,36,''),(20,14,47,''),(21,16,16,''),(22,18,7,''),(23,18,19,''),(24,18,16,''),(25,18,2,''),(26,24,45,''),(27,25,12,''),(28,25,39,''),(29,25,19,''),(30,28,47,''),(31,30,49,''),(32,30,48,''),(33,30,37,''),(34,31,32,''),(35,31,17,''),(36,32,11,''),(37,32,35,''),(38,33,34,''),(39,36,32,''),(40,36,14,''),(41,36,37,''),(42,37,46,''),(43,38,27,''),(44,41,21,'тут  закупаются конкуренты'),(45,41,25,''),(46,41,33,'подписать договор'),(47,41,43,''),(48,44,6,''),(49,44,17,''),(50,44,48,''),(51,44,47,''),(52,44,2,''),(53,47,5,''),(54,47,42,''),(55,49,31,''),(56,49,39,'качество как будто сделано в гараже'),(57,54,41,''),(58,54,44,''),(59,55,38,''),(60,57,33,''),(61,57,47,''),(62,66,23,''),(63,66,31,''),(64,66,26,'не звонить, должны денег'),(65,70,4,''),(66,71,50,'занюхнул вот эту - вообще огонь'),(67,72,50,''),(68,73,29,''),(69,73,16,'отправить недостающие документы'),(70,73,31,'позвонить завтра'),(71,74,1,''),(72,78,50,''),(73,78,45,''),(74,80,49,'почему РыбВектор производит резину?'),(75,82,7,''),(76,82,45,''),(77,82,42,''),(78,83,38,''),(79,84,8,''),(80,84,40,'как сдать экзамен?'),(81,84,27,''),(82,84,5,''),(83,84,26,''),(84,86,6,''),(85,86,27,''),(86,86,40,''),(87,86,11,''),(88,86,37,''),(89,86,25,''),(90,88,30,''),(91,90,1,''),(92,91,31,''),(93,91,4,''),(94,92,47,''),(95,92,26,''),(96,92,16,'цена дорогая, но качетво хорошее'),(97,92,48,''),(98,92,35,''),(99,100,14,''),(100,100,49,'');
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
  `ProductTypeID` int DEFAULT NULL,
  `ArticleNumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ProductionPersonCount` int DEFAULT NULL,
  `ProductionWorkshopNumber` int DEFAULT NULL,
  `MinCostForAgent` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Product_ProductType` (`ProductTypeID`),
  CONSTRAINT `FK_Product_ProductType` FOREIGN KEY (`ProductTypeID`) REFERENCES `producttype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
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
  `ProductID` int NOT NULL,
  `MaterialID` int NOT NULL,
  `Count` double DEFAULT NULL,
  PRIMARY KEY (`ProductID`,`MaterialID`),
  KEY `FK_ProductMaterial_Material` (`MaterialID`),
  CONSTRAINT `FK_ProductMaterial_Material` FOREIGN KEY (`MaterialID`) REFERENCES `material` (`ID`),
  CONSTRAINT `FK_ProductMaterial_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmaterial`
--

LOCK TABLES `productmaterial` WRITE;
/*!40000 ALTER TABLE `productmaterial` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'ГаражТелекомГор','1718185951','2018-11-26',18,'МКК'),(2,'Компания Омск','1878504395','2012-05-10',49,'ОАО'),(3,'ГорМонтаж','1564667734','2013-07-10',39,'ООО'),(4,'Микро','2293562756','2014-07-15',25,'МКК'),(5,'Электро','1755853973','2012-05-14',43,'ЗАО'),(6,'Компания Мотор','1429908355','2010-09-16',85,'ООО'),(7,'Асбоцем','1944834477','2012-09-07',23,'МФО'),(8,'ВостокМети','1488487851','2019-04-08',51,'ООО'),(9,'МясКрепТеле','2152486844','2013-03-17',78,'ПАО'),(10,'Софт','1036521658','2017-10-13',84,'МКК'),(11,'Компания СервисМикроО','1178826599','2013-04-14',27,'ООО'),(12,'ИнфоГазМотор','1954050214','2011-02-10',92,'ОАО'),(13,'Монтаж','1163880101','2019-06-01',66,'ОАО'),(14,'ЭлектроХром','1654184411','2014-08-17',13,'ОАО'),(15,'Компания НефтьITИнф','1685247455','2014-09-26',56,'ООО'),(16,'ТомскНефть','1002996016','2010-01-13',44,'ООО'),(17,'ТомскТяжРеч','1102143492','2010-09-11',59,'МФО'),(18,'УралХме','2291253256','2010-06-15',40,'ООО'),(19,'ВодРыб','1113468466','2016-09-20',38,'ЗАО'),(20,'УралСервисМон','1892306757','2015-04-22',77,'МКК'),(21,'Казань','1965011544','2017-04-21',77,'ОАО'),(22,'Cиб','1949139718','2010-10-26',89,'ОАО'),(23,'ГаражГазМ','1740623312','2017-10-07',99,'ОАО'),(24,'МобайлДизайнОмск','1014490629','2011-05-10',99,'ООО'),(25,'ЖелДорГаз','1255275062','2017-09-07',25,'МФО'),(26,'ТверьБухГаз','2167673760','2014-03-26',54,'ОАО'),(27,'ТелекомТранс','2200735978','2019-02-17',87,'ОАО'),(28,'ГаражГлав','1404774111','2014-11-20',1,'МКК'),(29,'Компания К','1468114280','2014-08-09',54,'ПАО'),(30,'ТяжЛифтВостокС','1032089879','2018-03-01',70,'ОАО'),(31,'Компания Во','2027005945','2014-04-08',23,'ПАО'),(32,'МоторКаз','1076279398','2015-08-27',37,'ОАО'),(33,'Сервис','2031832854','2014-03-11',5,'ОАО'),(34,'ЮпитерТомс','1551173338','2010-06-05',11,'ПАО'),(35,'Мор','1906157177','2010-10-14',38,'МКК'),(36,'СеверТехВостокЛизинг','1846812080','2010-12-26',34,'ООО'),(37,'ЦементОбл','2021607106','2012-11-14',46,'ООО'),(38,'Компания КазаньАвтоCиб','1371692583','2010-04-16',72,'МКК'),(39,'ГаражХозФлот','2164720385','2019-01-03',19,'ОАО'),(40,'Компания МорМетал','1947163072','2010-02-25',93,'ООО'),(41,'ГлавРыб','1426268088','2013-12-07',59,'МФО'),(42,'CибCибОрио','1988313615','2019-02-22',1,'ООО'),(43,'ТелеРыбХм','2299034130','2019-02-21',51,'ООО'),(44,'ГлавАвтоГазТрест','2059691335','2013-07-17',28,'МФО'),(45,'ТяжКазаньБашкир','1794419510','2016-06-01',55,'ПАО'),(46,'Асбоцемент','1650212184','2018-12-08',32,'МФО'),(47,'Мотор','1019917089','2017-09-09',59,'ПАО'),(48,'МорФинансФинансМаш','1549496316','2016-04-15',50,'ООО'),(49,'РыбВектор','2275526397','2010-11-25',72,'ОАО'),(50,'Теле','2170198203','2010-04-13',96,'ПАО');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp` (
  `material_title` varchar(100) NOT NULL,
  `supplier_title` varchar(100) NOT NULL,
  `comment` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
INSERT INTO `temp` VALUES ('Силикон 1x1','Компания Во','позвонить завтра'),('Краска 2x31','Мотор',''),('Силикон 1x1','ТомскНефть','отправить недостающие документы'),('Силикон 1x1','Компания К',''),('Краска 1x1','ТяжЛифтВостокС',''),('Силикон 0x2','Компания КазаньАвтоCиб',''),('Резина 1x1','ТверьБухГаз','не звонить, должны денег'),('Краска 2x2','ГлавАвтоГазТрест',''),('Краска 2x2','ГлавРыб',''),('Краска 2x24','ТяжКазаньБашкир',''),('Резина 1x1','Компания Во',''),('Резина 1x1','ГаражГазМ',''),('Краска 2x24','Теле',''),('Резина 0x1','ГаражТелекомГор',''),('Резина 1x3','Компания СервисМикроО',''),('Силикон 0x1','Компания КазаньАвтоCиб',''),('Краска 2x0','ГаражХозФлот','качество как будто сделано в гараже'),('Краска 2x0','Компания Во',''),('Краска 2x1','ТелеРыбХм',''),('Резина 3x2','CибCибОрио',''),('Краска 2x28','РыбВектор',''),('Краска 2x1','Сервис','подписать договор'),('Краска 2x28','ЭлектроХром',''),('Краска 2x1','ЖелДорГаз',''),('Резина 3x2','Электро',''),('Краска 2x1','Казань','тут  закупаются конкуренты'),('Краска 1x0','ТверьБухГаз',''),('Резина 11x0','Компания Омск',''),('Краска 1x0','Электро',''),('Краска 1x0','ТелекомТранс',''),('Краска 3x14','Мотор',''),('Краска 1x0','Компания МорМетал','как сдать экзамен?'),('Краска 1x0','ВостокМети',''),('Резина 1x14','ТомскНефть',''),('Резина 11x0','Мотор',''),('Силикон 3x18','ТелекомТранс',''),('Резина 11x0','МорФинансФинансМаш',''),('Резина 11x0','ТомскТяжРеч',''),('Краска 3x14','СеверТехВостокЛизинг',''),('Краска 3x14','УралСервисМон',''),('Резина 1x14','УралСервисМон',''),('Резина 11x0','Компания Мотор',''),('Резина 1x14','Теле',''),('Резина 3x1','ГаражТелекомГор',''),('Силикон 2x1','Мор',''),('Силикон 0x12','ТяжКазаньБашкир',''),('Резина 0x3','Микро',''),('Силикон 2x1','МорФинансФинансМаш',''),('Силикон 2x1','ТомскНефть','цена дорогая, но качетво хорошее'),('Силикон 2x1','ТверьБухГаз',''),('Силикон 2x1','Мотор',''),('Силикон 1x2','Компания Омск',''),('Силикон 3x14','ЦементОбл',''),('Силикон 1x2','ТомскНефть',''),('Силикон 3x15','ТомскНефть',''),('Силикон 3x14','ЭлектроХром',''),('Силикон 1x2','ВодРыб',''),('Резина 3x23','Мотор',''),('Силикон 3x14','МоторКаз',''),('Силикон 1x2','Асбоцем',''),('Резина 3x23','Сервис',''),('Краска 2x3','ТверьБухГаз',''),('Силикон 3x2','ВодРыб',''),('Резина 1x37','Сервис',''),('Силикон 3x2','ГаражХозФлот',''),('Резина 3x3','Компания К',''),('Силикон 3x2','ИнфоГазМотор',''),('Краска 2x3','Cиб',''),('Краска 2x3','Асбоцем',''),('Резина 1x37','РыбВектор',''),('Силикон 3x1','Микро',''),('Краска 1x2','Электро',''),('Силикон 3x1','Компания Во',''),('Силикон 3x0','ЖелДорГаз',''),('Краска 4x04','Теле','занюхнул вот эту - вообще огонь'),('Силикон 3x0','ЦементОбл',''),('Краска 4x0','ЦементОбл',''),('Силикон 3x0','Компания СервисМикроО',''),('Силикон 3x0','Компания МорМетал',''),('Краска 1x2','Софт',''),('Краска 1x2','ЭлектроХром',''),('Краска 4x0','МорФинансФинансМаш',''),('Силикон 3x0','ТелекомТранс',''),('Краска 4x0','РыбВектор',''),('Резина 1x32','Теле',''),('Силикон 3x0','Компания Мотор',''),('Краска 3x18','CибCибОрио',''),('Краска 3x2','ЮпитерТомс',''),('Резина 1x0','Мор',''),('Резина 2x1','ВодРыб',''),('Краска 3x18','ТяжКазаньБашкир',''),('Резина 1x0','Компания СервисМикроО',''),('Резина 2x1','ГаражГлав',''),('Резина 2x1','ГаражТелекомГор',''),('Краска 3x18','Асбоцем',''),('Силикон 3x3','Асбоцемент',''),('Резина 2x1','Компания Мотор','помогите меня держат в заложниках и я работаю за еду'),('Краска 2x4','ТомскТяжРеч',''),('Краска 2x4','МоторКаз',''),('Резина 3x38','РыбВектор','почему РыбВектор производит резину?');
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'demoexam4'
--

--
-- Dumping routines for database 'demoexam4'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-16 15:52:24
