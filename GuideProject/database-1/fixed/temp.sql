ГГГГ-ММ-ДД ЧЧ:ММ:СС

CREATE TABLE IF NOT EXISTS temp (
	service_title VARCHAR(256) NOT NULL,
	client_lastname VARCHAR(256) NOT NULL,
	start_datetime DATETIME NOT NULL
);

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

INSERT INTO clientservice(ClientID, ServiceID, StartTime)
SELECT client.ID as ClientID, service.ID as ServiceID, temp.start_datetime as StartTime
FROM temp
INNER JOIN client ON client.LastName = temp.client_lastname
INNER JOIN service ON service.Title = temp.service_title
