DROP TABLE IF EXISTS pirates;
DROP TABLE IF EXISTS ships;

CREATE TABLE ships (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	ship_name VARCHAR(255) NOT NULL
);

CREATE TABLE pirates (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	ship_id INTEGER NOT NULL,
	CONSTRAINT fk_pirates_ships FOREIGN KEY (ship_id) REFERENCES ships (id) ON DELETE CASCADE
);

INSERT INTO ships (ship_name)
VALUES
('Queen Anne''s Revenge');

SELECT *
FROM ships;

INSERT INTO pirates (first_name, last_name, ship_id)
VALUES
('Edward', 'Thatch', 1);

SELECT *
FROM pirates;

SELECT p.id AS pirate_id, p.first_name, p.last_name, s.id AS ship_id, s.ship_name 
FROM pirates p
INNER JOIN ships s 
ON p.ship_id = s.id;



