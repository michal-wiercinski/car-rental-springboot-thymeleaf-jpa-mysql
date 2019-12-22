INSERT INTO `brand` (`id`, `name`)
VALUES (1, 'BMW'),
       (2, 'Mercedes'),
       (3, 'Volkswagen'),
       (4, 'Nissan'),
       (5, 'Toyota'),
       (6, 'Renault'),
       (7, 'Ford'),
       (8, 'Hyundai'),
       (9, 'Audi'),
       (10, 'Citroen'),
       (11, 'Honda'),
       (12, 'Porshe'),
       (13, 'Mitsubishi'),
       (14, 'Volvo'),
       (15, 'Lexus');


insert into car_model (name, brand_id)
values ('X3', 1),
       ('X4', 1),
       ('X5', 1),
       ('X7', 1),
       ('Seria 2', 1),
       ('Seria 3', 1),
       ('Seria 4', 1),
       ('Seria 5', 1),
       ('Seria 6', 1),
       ('Seria 7', 1),
       ('W169', 2),
       ('W176', 2),
       ('W177', 2),
       ('C118', 2),
       ('C117', 2),
       ('W222', 2),
       ('C180', 2),
       ('S350', 2),
       ('S400', 2),
       ('E200', 2),
       ('C200', 2);

insert into body_type (type_name)
values ('Hatchback'),
       ('Kombi'),
       ('Sedan'),
       ('SUV');

insert into location (name)
values ('Warsaw Chopin Airport '),
       ('John Paul II International Airport Kraków–Balice '),
       ('Gdańsk Lech Wałęsa Airport '),
       ('Katowice Airport '),
       ('Wrocław-Copernicus Airport '),
       ('Warsaw Modlin Airport '),
       ('Poznań–Ławica Henryk Wieniawski Airport '),
       ('Rzeszów–Jasionka Airport '),
       ('Solidarity Szczecin–Goleniów Airport '),
       ('Lublin Airport '),
       ('Bydgoszcz Ignacy Jan Paderewski Airport '),
       ('Olsztyn-Mazury Airport '),
       ('Zielona Góra-Babimost Airport'),
       ('Łódź Władysław Reymont Airport ');


insert into role (id, name)
values (1, 'SUPERADMIN'),
       (2, 'ADMIN'),
       (3, 'USER');

insert into rental_status (id, status_description)
values (1, 'canceled'),
       (2, 'rented'),
       (3, 'reserved'),
       (4, 'returned');