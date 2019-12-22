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

create table address
(
    id              bigint auto_increment
        primary key,
    city            varchar(255) null,
    house_number    varchar(255) null,
    street          varchar(255) null,
    zip_code varchar(255) null
);

create table body_type
(
    id        bigint auto_increment
        primary key,
    type_name varchar(255) null
);

create table brand
(
    id           bigint auto_increment
        primary key,
    name         varchar(255) null,
    phone_number varchar(255) null,
    address_id   bigint       null,
    foreign key (address_id) references address (id)
);

create table rental_status
(
    id                 bigint auto_increment
        primary key,
    status_description varchar(255) null
);

create table car_model
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) null,
    brand_id bigint       null,
    foreign key (brand_id) references brand (id)
);

create table car_parameter
(
    id                       bigint auto_increment
        primary key,
    current_mileage          int null,
    engine_size              int null,
    year_of_prod             int null,
    average_fuel_consumption int null,
    daily_rate               int null
);

create table location
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table car
(
    id                  bigint auto_increment
        primary key,
    registration_number varchar(255) not null,
    is_rent             bit          null,
    body_type_id        bigint       null,
    car_model_id        bigint       null,
    location_id         bigint       null,
    car_parameter_id    bigint       null,
    foreign key (car_parameter_id) references car_parameter (id),
    foreign key (car_model_id) references car_model (id),
    foreign key (body_type_id) references body_type (id),
    foreign key (location_id) references location (id)
);


create table customer
(
    id         bigint auto_increment
        primary key,
    address_id bigint null,
    user_id    bigint null,
    foreign key (address_id) references address (id)
);



create table user
(
    id          bigint auto_increment
        primary key,
    email       varchar(255) null,
    first_name  varchar(255) null,
    last_name   varchar(255) null,
    customer_id bigint       null,
    foreign key (customer_id) references customer (id)
);

alter table customer
    add foreign key (user_id) references user (id);

create table rental
(
    id          bigint auto_increment
        primary key,
    date_from   datetime(6)  null,
    date_to     datetime(6)  null,
    customer_id bigint       null,
    status_id   bigint       null,
    car_id      bigint null,
    foreign key (customer_id) references customer (id),
    foreign key (car_id) references car (id),
    foreign key (status_id) references rental_status (id)
);











