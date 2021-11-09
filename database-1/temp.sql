CREATE TABLE temp (
	service_title VARCHAR(256) NOT NULL,
	service_start_time DATETIME NOT NULL,
	client_lastname VARCHAR(256) NOT NULL
);

INSERT INTO clientservice (ClientID, ServiceID, StartTime)
SELECT client.ID as ClientID, service.ID as ServiceID, temp.service_start_time as StartTime
FROM temp
INNER JOIN client ON temp.client_lastname = client.LastName
INNER JOIN service ON temp.service_title = service.Title