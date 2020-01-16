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
drop table if exists car_status;
drop view if exists car_detail_view;

create table address
(
    id_address   bigint auto_increment
        primary key,
    city         varchar(255) not null,
    street       varchar(255) not null,
    house_number varchar(255) not null,
    flat_number  varchar(255) not null,
    zip_code     varchar(255) not null
);

create table body_type
(
    id_body_type bigint auto_increment
        primary key,
    type_name    varchar(255) not null
);

create table brand
(
    id_brand   bigint auto_increment
        primary key,
    brand_name varchar(255) not null
    /* phone_number varchar(255) not null,
     address_id   bigint       not null,*/
    /*  foreign key (address_id) references address (id)*/
);

create table rental_status
(
    id_status   bigint auto_increment
        primary key,
    status_desc varchar(255) not null
);

create table car_model
(
    id_car_model   bigint auto_increment
        primary key,
    car_model_name varchar(255) not null,
    brand_id       bigint       not null,
    foreign key (brand_id) references brand (id_brand)
);

create table car_parameter
(
    id_car_parameter bigint auto_increment
        primary key,
    current_mileage  int    not null,
    engine_size      int    not null,
    power            int    not null,
    year_of_prod     int    not null,
    fuel_consumption int    not null,
    daily_rate       int    not null,
    body_type_id     bigint not null,
    foreign key (body_type_id) references body_type (id_body_type)

    -- car_id           bigint not null
);

create table location
(
    id_location   bigint auto_increment
        primary key,
    location_name varchar(255) not null
);

create table role
(
    id_role   bigint auto_increment
        primary key,
    role_name varchar(255) not null
);

create table customer
(
    id_customer bigint auto_increment
        primary key,
    address_id  bigint not null,
    user_id     bigint not null,
    foreign key (address_id) references address (id_address)
);


create table car_status
(
    status_code        varchar(3)  not null primary key,
    status_description varchar(50) not null
);


create table car
(
    id_car              bigint auto_increment
        primary key,
    registration_number varchar(255)  not null,

    car_model_id        bigint        not null,
    location_id         bigint        not null,
    car_parameter_id    bigint unique not null,
    car_status          varchar(3)    not null,
    foreign key (car_parameter_id) references car_parameter (id_car_parameter),
    foreign key (car_model_id) references car_model (id_car_model),
    foreign key (location_id) references location (id_location),
    foreign key (car_status) references car_status (status_code)
);



create table user
(
    id_user     bigint auto_increment
        primary key,
    email       varchar(255) not null,
    first_name  varchar(255) not null,
    last_name   varchar(255) not null,
    customer_id bigint       not null,
    foreign key (customer_id) references customer (id_customer)
);



create table rental
(
    id_rental   bigint auto_increment
        primary key,
    date_from   datetime(6)                not null,
    date_end    datetime(6)                not null,
    rental_cost decimal(10, 4) default 0.0 not null,
    customer_id bigint                     not null,
    status_id   bigint                     not null,
    car_id      bigint                     not null,
    foreign key (customer_id) references customer (id_customer),
    foreign key (car_id) references car (id_car),
    foreign key (status_id) references rental_status (id_status)
);



alter table customer
    add foreign key (user_id) references user (id_user);

-- alter table car_parameter
-- add foreign key  (car_id) references car (id_car);


create or replace view details_fleet
as
select c.id_car                        as 'car_id',
       coalesce(sum(r.rental_cost), 0) as 'income',
       br.brand_name                   as 'brand',
       cm.car_model_name               as 'car_model',
       bt.type_name                    as 'body_type',
       cp.power                        as 'engine_power',
       cp.engine_size                  as 'engine_size',
       cp.year_of_prod                 as 'production_year',
       cp.current_mileage              as 'current_mileage',
       cp.daily_rate                   as 'daily_rate',
       cs.status_description           as 'status'

from car as c
         left join car_model as cm on c.car_model_id = cm.id_car_model
         left join car_parameter as cp
                   on c.car_parameter_id = cp.id_car_parameter
         left join car_status cs on c.car_status = cs.status_code
         left join brand as br on cm.brand_id = br.id_brand
         left join body_type as bt on cp.body_type_id = bt.id_body_type
         left join rental r on c.id_car = r.car_id
group by c.id_car, r.rental_cost;










