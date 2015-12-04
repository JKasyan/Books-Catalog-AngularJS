SELECT b.id_book, b.title, b.short_description, b.date_publish,
  ARRAY_AGG(a.second_name || ' ' || a.first_name || ' ' || a.id_author)
FROM book b
  LEFT JOIN author_book ab
    ON b.id_book = ab.id_book
  LEFT JOIN author a
    ON a.id_author = ab.id_author
GROUP BY b.id_book;

INSERT INTO author
(first_name, second_name)
VALUES ('Ernest', 'Hemingway'),
  ('Михаил','Лермонтов'),
  ('Александр','Солженицын');

INSERT INTO book
(title, short_description, date_publish)
    VALUES ('Мцыри','романтическая поэма М. Ю. Лермонтова','1839'),
      ('В круге первом','роман Александра Солженицына','1955');