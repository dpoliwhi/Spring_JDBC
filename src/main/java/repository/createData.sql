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
    id     serial primary key,
    title  varchar(30) not null,
    author varchar(30) not null
);

INSERT INTO users (firstname, lastname, birthday, phone, email, books)
VALUES ('Евгений', 'Поноарев', '2000-03-17', '8-923-705-4446', 'ornare.in@yahoo.net', 'Старик и море, 1984'),
       ('Игорь', 'Ревякин', '2006-06-18', '8-999-775-4444', 'eu.augue@yahoo.org', 'Фиеста, Скотный двор'),
       ('Никита', 'Бикаев', '2009-04-21', '8-945-765-1268', 'ipsum.sodales@hotmail.com', 'Шантарам, Скотный двор, 1984'),
       ('Кристина', 'Куркина', '2011-04-23', '8-999-767-9968', 'mollis.integer.tincidunt@icloud.ca', 'Фиеста'),
       ('Марина', 'Демидова', '2020-12-03', '8-999-000-7867', 'orci.tincidunt@aol.couk', 'Эссенциализм, Тень горы, Тревожные люди'),
       ('Алексей', 'Демидов', '2016-04-08', '8-922-222-2121', 'in.scelerisque.scelerisque@aol.edu', 'Крестный отец, Шантарам, 1984, Старик и море'),
       ('Леонид', 'Крюкин', '1992-09-09', '8-922-122-1212', 'ultrices.posuere@icloud.couk', 'Фиеста, Эссенциализм'),
       ('Яна', 'Фыркина', '2001-12-03', '8-923-121-4312', 'erat.vivamus.nisi@icloud.ca', 'Вторая жизнь Уве, Скотный двор'),
       ('Полина', 'Абдюшева', '2019-10-10', '8-923-345-7756', 'non@protonmail.ca', null),
       ('Виталий', 'Шнайдер', '2019-10-10', '8-932-432-8646', 'non@protonmail.ca', 'Тревожные люди, Скотный двор, Старик и море');

INSERT INTO Library (title, author)
VALUES ('Старик и море', 'Хумингуэй'),
       ('Фиеста', 'Хумингуэй'),
       ('Скотный двор', 'Д. Оруэл'),
       ('1984', 'Д. Оруэл'),
       ('Шантарам', 'П.Д. Робертс'),
       ('Тень горы', 'П.Д. Робертс'),
       ('Тревожные люди', 'Ф. Бакман'),
       ('Вторая жизнь Уве', 'Ф. Бакман'),
       ('Крестный отец', 'М. Пьюзо'),
       ('Эссенциализм', 'Г. МакКеон');

