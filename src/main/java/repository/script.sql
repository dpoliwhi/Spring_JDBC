CREATE TABLE Users
(
    id     serial primary key,
    firstname varchar(30) not null,
    lastname  varchar(30) not null,
    birthday  date,
    phone varchar(15),
    email  varchar(50)
);