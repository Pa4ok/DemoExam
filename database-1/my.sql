SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Table Manufacturer
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Manufacturer` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `StartDate` DATE NULL,
  PRIMARY KEY (`ID`));

-- ----------------------------------------------------------------------------
-- Table Product
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Product` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `Cost` DECIMAL(19,4) NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `MainImagePath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  `IsActive` TINYINT(1) NOT NULL,
  `ManufacturerID` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_Product_Manufacturer`
    FOREIGN KEY (`ManufacturerID`)
    REFERENCES `Manufacturer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table Gender
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gender` (
  `Code` CHAR(1) CHARACTER SET 'utf8mb4' NOT NULL,
  `Name` VARCHAR(10) CHARACTER SET 'utf8mb4' NULL,
  PRIMARY KEY (`Code`));

-- ----------------------------------------------------------------------------
-- Table Client
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Client` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(50) CHARACTER SET 'utf8mb4' NOT NULL,
  `LastName` VARCHAR(50) CHARACTER SET 'utf8mb4' NOT NULL,
  `Patronymic` VARCHAR(50) CHARACTER SET 'utf8mb4' NULL,
  `Birthday` DATE NULL,
  `RegistrationDate` DATETIME(6) NOT NULL,
  `Email` VARCHAR(255) CHARACTER SET 'utf8mb4' NULL,
  `Phone` VARCHAR(20) CHARACTER SET 'utf8mb4' NOT NULL,
  `GenderCode` CHAR(1) CHARACTER SET 'utf8mb4' NOT NULL,
  `PhotoPath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_Client_Gender`
    FOREIGN KEY (`GenderCode`)
    REFERENCES `Gender` (`Code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table TagOfClient
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `TagOfClient` (
  `ClientID` INT NOT NULL,
  `TagID` INT NOT NULL,
  PRIMARY KEY (`ClientID`, `TagID`),
  CONSTRAINT `FK_TagOfClient_Client`
    FOREIGN KEY (`ClientID`)
    REFERENCES `Client` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TagOfClient_Tag`
    FOREIGN KEY (`TagID`)
    REFERENCES `Tag` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table Tag
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tag` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(30) CHARACTER SET 'utf8mb4' NOT NULL,
  `Color` CHAR(6) CHARACTER SET 'utf8mb4' NOT NULL,
  PRIMARY KEY (`ID`));

-- ----------------------------------------------------------------------------
-- Table Service
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `Cost` DECIMAL(19,4) NOT NULL,
  `DurationInSeconds` INT NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `Discount` DOUBLE NULL,
  `MainImagePath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  PRIMARY KEY (`ID`));

-- ----------------------------------------------------------------------------
-- Table ServicePhoto
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicePhoto` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ServiceID` INT NOT NULL,
  `PhotoPath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ServicePhoto_Service`
    FOREIGN KEY (`ServiceID`)
    REFERENCES `Service` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table ProductSale
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProductSale` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `SaleDate` DATETIME(6) NOT NULL,
  `ProductID` INT NOT NULL,
  `Quantity` INT NOT NULL,
  `ClientServiceID` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ProductSale_Product`
    FOREIGN KEY (`ProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductSale_ClientService`
    FOREIGN KEY (`ClientServiceID`)
    REFERENCES `ClientService` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table ClientService
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ClientService` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ClientID` INT NOT NULL,
  `ServiceID` INT NOT NULL,
  `StartTime` DATETIME(6) NOT NULL,
  `Comment` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ClientService_Client`
    FOREIGN KEY (`ClientID`)
    REFERENCES `Client` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ClientService_Service`
    FOREIGN KEY (`ServiceID`)
    REFERENCES `Service` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table ProductPhoto
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProductPhoto` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ProductID` INT NOT NULL,
  `PhotoPath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ProductPhoto_Product`
    FOREIGN KEY (`ProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table DocumentByService
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `DocumentByService` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ClientServiceID` INT NOT NULL,
  `DocumentPath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_DocumentByService_ClientService`
    FOREIGN KEY (`ClientServiceID`)
    REFERENCES `ClientService` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table AttachedProduct
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `AttachedProduct` (
  `MainProductID` INT NOT NULL,
  `AttachedProductID` INT NOT NULL,
  PRIMARY KEY (`MainProductID`, `AttachedProductID`),
  CONSTRAINT `FK_AttachedProduct_Product1`
    FOREIGN KEY (`AttachedProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_AttachedProduct_Product`
    FOREIGN KEY (`MainProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
SET FOREIGN_KEY_CHECKS = 1;