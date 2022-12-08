CREATE TABLE Users
(
    id        serial primary key,
    firstname varchar(30) not null,
    lastname  varchar(30) not null,
    birthday  date,
    phone     varchar(15) not null,
    email     varchar(50) not null,
    books     varchar
);

CREATE TABLE Library
(
    id         serial primary key,
    title      varchar(30) not null,
    author     varchar(30) not null,
    date_added date
);