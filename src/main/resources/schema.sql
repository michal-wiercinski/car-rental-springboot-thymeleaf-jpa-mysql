drop table if exists address;
drop table if exists body_type;
drop table if exists car;
drop table if exists car_model;
drop table if exists car_parameter;
drop table if exists customer;
drop table if exists location;
drop table if exists manufacturer;
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
    zip_code        varchar(255) null,
    manufacturer_id bigint       null,
    constraint FKghvdmsmi1l2oi3ubjqd5di1ml
        foreign key (manufacturer_id) references manufacturer (id)
);

create table body_type
(
    id        bigint auto_increment
        primary key,
    type_name varchar(255) null
);

create table car
(
    registration_number varchar(255) not null
        primary key,
    is_rent             bit          null,
    body_type_id        bigint       null,
    car_model_id        bigint       null,
    location_id         bigint       null,
    rental_id           bigint       null,
    car_parameter       bigint       null,
    constraint FKc9d4bc07pgw3194idsmkq50pf
        foreign key (car_parameter) references car_parameter (id),
    constraint FKgfht1l5lcn8gbugha10mnt4bg
        foreign key (car_model_id) references car_model (id),
    constraint FKj3q505x6k5oe468g1xwnwdpfh
        foreign key (rental_id) references rental (id),
    constraint FKpjdv4cvggj9o1c7x5owvky5wt
        foreign key (body_type_id) references body_type (id),
    constraint FKsjeo31bkla3haqy6x9hf5ij0o
        foreign key (location_id) references location (id)
);

create table car_model
(
    id              bigint auto_increment
        primary key,
    name            varchar(255) null,
    manufacturer_id bigint       null,
    constraint FKt05p9otmh20bpkesiiuker681
        foreign key (manufacturer_id) references manufacturer (id)
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

create table customer
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) null,
    surname    varchar(255) null,
    address_id bigint       null,
    user_id    bigint       null,
    constraint FKglkhkmh2vyn790ijs6hiqqpi
        foreign key (address_id) references address (id),
    constraint FKj8dlm21j202cadsbfkoem0s58
        foreign key (user_id) references user (id)
);

create table location
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table manufacturer
(
    id           bigint auto_increment
        primary key,
    name         varchar(255) null,
    phone_number varchar(255) null,
    address_id   bigint       null,
    constraint FKaselfumd9974uilhj1mwylo2p
        foreign key (address_id) references address (id)
);

create table rental
(
    id          bigint auto_increment
        primary key,
    date_from   datetime(6)  null,
    date_to     datetime(6)  null,
    customer_id bigint       null,
    status_id   bigint       null,
    vehicle_id  varchar(255) null,
    constraint FK7jf1f7b8w6jotl5qw1kxn8114
        foreign key (customer_id) references customer (id),
    constraint FKmywstyex7g7w81pgp860reakw
        foreign key (vehicle_id) references car (registration_number),
    constraint FKq5mry1ym8biw4556jr9bpfrgd
        foreign key (status_id) references rental_status (id)
);

create table rental_status
(
    id                 bigint auto_increment
        primary key,
    status_description varchar(255) null
);

create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table user
(
    id          bigint auto_increment
        primary key,
    email       varchar(255) null,
    enabled     bit          not null,
    first_name  varchar(255) null,
    last_name   varchar(255) null,
    password    varchar(60)  null,
    secret      varchar(255) null,
    customer_id bigint       null,
    constraint FKdptx0i3ky01svofwjytq5iry0
        foreign key (customer_id) references customer (id)
);







