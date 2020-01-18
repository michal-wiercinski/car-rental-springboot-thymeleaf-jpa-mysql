drop database if exists carRental;
create database carRental;

use carRental;

drop table if exists address;
drop table if exists body_type;
drop table if exists car;
drop table if exists car_model;
drop table if exists car_parameter;
drop table if exists customer;
drop table if exists location;
drop table if exists brand;
drop table if exists rental;
drop table if exists rental_status;
drop table if exists role;
drop table if exists user;
drop table if exists user_roles;
drop table if exists car_status;
drop view if exists car_detail_view;

create table address
(
    PK_address   bigint auto_increment
        primary key,
    city         varchar(255) not null,
    street       varchar(255) not null,
    house_number varchar(255) not null,
    flat_number  varchar(255) not null,
    zip_code     varchar(255) not null
);

create table body_type
(
    PK_body_type bigint auto_increment
        primary key,
    type_name    varchar(255) not null
);

create table brand
(
    PK_brand   bigint auto_increment
        primary key,
    brand_name varchar(255) not null
    /* phone_number varchar(255) not null,
     address_id   bigint       not null,*/
    /*  foreign key (address_id) references address (id)*/
);

create table rental_status
(
    PK_status   bigint auto_increment
        primary key,
    status_desc varchar(255) not null
);

create table car_model
(
    PK_car_model   bigint auto_increment
        primary key,
    car_model_name varchar(255) not null,
    FK_brand       bigint       not null,
    foreign key (FK_brand) references brand (PK_brand)
);

create table car_parameter
(
    PK_car_parameter bigint auto_increment
        primary key,
    current_mileage  int    not null,
    engine_size      int    not null,
    power            int    not null,
    year_of_prod     int    not null,
    fuel_consumption double not null,
    daily_rate       int    not null,
    FK_body_type     bigint not null,
    foreign key (FK_body_type) references body_type (PK_body_type)

    -- car_id           bigint not null
);

create table location
(
    PK_location   bigint auto_increment
        primary key,
    location_name varchar(255) not null
);

create table role
(
    PK_role   bigint auto_increment
        primary key,
    role_name varchar(255) not null
);

create table customer
(
    PK_customer bigint auto_increment
        primary key,
    address_FK  bigint not null,
    user_FK     bigint not null,
    foreign key (address_FK) references address (PK_address)
);


create table car_status
(
    PK_status_code     varchar(3)  not null primary key,
    status_description varchar(50) not null
);


create table car
(
    PK_car              bigint auto_increment
        primary key,
    registration_number varchar(255)  not null,

    FK_car_model        bigint        not null,
    FK_location         bigint        not null,
    FK_car_parameter    bigint unique not null,
    FK_car_status       varchar(3)    not null,
    foreign key (FK_car_parameter) references car_parameter (PK_car_parameter),
    foreign key (FK_car_model) references car_model (PK_car_model),
    foreign key (FK_location) references location (PK_location),
    foreign key (FK_car_status) references car_status (PK_status_code)
);

create table user
(
    PK_user     bigint auto_increment
        primary key,
    email       varchar(255) not null,
    first_name  varchar(255) not null,
    last_name   varchar(255) not null,
    FK_customer bigint       not null,
    foreign key (FK_customer) references customer (PK_customer)
);

create table rental
(
    PK_rental   bigint auto_increment
        primary key,
    date_from   datetime(6)                not null,
    date_end    datetime(6)                not null,
    rental_cost decimal(10, 4) default 0.0 not null,
    FK_customer bigint                     not null,
    FK_status   bigint                     not null,
    FK_car      bigint                     not null,
    foreign key (FK_customer) references customer (PK_customer),
    foreign key (FK_car) references car (PK_car),
    foreign key (FK_status) references rental_status (PK_status)
);
/*
create table rentals_car
(
    FK_car    bigint not null,
    FK_rental bigint not null,
    foreign key (FK_car) references car (PK_car),
    foreign key (FK_rental) references rental (id_rental)
);
*/
create table user_roles
(
    FK_user bigint not null,
    FK_role bigint not null,
    foreign key (FK_user) references user (PK_user),
    foreign key (FK_role) references role (PK_role)
);

create or replace view details_fleet
as
select c.PK_car                        as 'car_id',
       coalesce(sum(r.rental_cost), 0) as 'income',
       br.brand_name                   as 'brand',
       cm.car_model_name               as 'car_model',
       bt.type_name                    as 'body_type',
       cp.power                        as 'engine_power',
       cp.engine_size                  as 'engine_size',
       cp.year_of_prod                 as 'production_year',
       cp.current_mileage              as 'current_mileage',
       cp.daily_rate                   as 'daily_rate',
       cs.status_description           as 'status',
       cp.fuel_consumption             as 'avg_fuel_consumption',
       l.location_name                 as 'location_name'
from car as c
         left join car_model as cm on c.FK_car_model = cm.PK_car_model
         left join car_parameter as cp
                   on c.FK_car_parameter = cp.PK_car_parameter
         left join car_status cs on c.FK_car_status = cs.PK_status_code
         left join brand as br on cm.FK_brand = br.PK_brand
         left join body_type as bt on cp.FK_body_type = bt.PK_body_type
         left join rental r on c.PK_car = r.FK_car
         left join location l on c.FK_location = l.PK_location
group by c.PK_car, r.rental_cost;



create or replace view details_fleet_for_user
as
select c.PK_car              as 'car_id',
       br.brand_name         as 'brand',
       cm.car_model_name     as 'car_model',
       bt.type_name          as 'body_type',
       cp.power              as 'engine_power',
       cp.engine_size        as 'engine_size',
       cp.year_of_prod       as 'production_year',
       cp.fuel_consumption   as 'avg_fuel_consumption',
       cp.daily_rate         as 'daily_rate',
       l.location_name       as 'location_name',
       cs.status_description as 'status'

from car as c
         left join car_model as cm on c.FK_car_model = cm.PK_car_model
         left join car_parameter as cp
                   on c.FK_car_parameter = cp.PK_car_parameter
         left join car_status cs on c.FK_car_status = cs.PK_status_code
         left join brand as br on cm.FK_brand = br.PK_brand
         left join body_type as bt on cp.FK_body_type = bt.PK_body_type
         left join location as l on l.PK_location = c.FK_location;











