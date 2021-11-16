CREATE TABLE temp (
	service_title VARCHAR(256) NOT NULL,
	client_lastname VARCHAR(256) NOT NULL,
	start_datetime DATETIME NOT NULL
);

INSERT INTO clientservice(ClientID, ServiceID, StartTime)
SELECT client.ID as ClientID, service.ID as ServiceID, temp.start_datetime as StartTime
FROM temp
INNER JOIN client ON client.LastName = temp.client_lastname
INNER JOIN service ON service.Title = temp.service_title