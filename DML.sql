DROP DATABASE teste_jsf;
CREATE DATABASE teste_jsf;
USE teste_jsf;

CREATE TABLE car (
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    model VARCHAR (50),
    name VARCHAR (50),
    price DECIMAL(10,2),
    version int 
);

INSERT INTO car 
	(model, name, price) VALUES 
    ('2010', 'Renault Megane', 15000), 
    ('2001', 'Chevrolet Vectra', 25000),
    ('2017', 'Volkswagen Jetta', 22600),
    ('2015', 'Peugeot 207', 35800),
    ('2016', 'Audi A4', 65840),
    ('2002', 'Fiat Punto', 12650),
    ('2011', 'Honda Civic', 15050);

SELECT * FROM car;