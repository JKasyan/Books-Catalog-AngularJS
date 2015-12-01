SELECT b.title, a.first_name
FROM book b
INNER JOIN author_book ab
ON b.id_book = ab.id_book
RIGHT OUTER JOIN author a
ON a.id_author = ab.id_author;

CREATE TABLE author_book
(
  id_author integer NOT NULL,
  id_book integer NOT NULL,
  CONSTRAINT pk PRIMARY KEY (id_author, id_book),
  CONSTRAINT fk_author FOREIGN KEY (id_author)
  REFERENCES author (idauthor) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_book FOREIGN KEY (id_book)
  REFERENCES book (idbook) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE author
(
  id_author integer NOT NULL DEFAULT nextval('author_idauthor_seq'::regclass),
  first_name text NOT NULL,
  second_name integer NOT NULL,
  CONSTRAINT author_pkey PRIMARY KEY (id_author)
);

CREATE TABLE book
(
  id_book integer NOT NULL DEFAULT nextval('book_idbook_seq'::regclass),
  title text NOT NULL,
  short_description text NOT NULL,
  date_publish text NOT NULL,
  CONSTRAINT pk_book PRIMARY KEY (id_book),
  CONSTRAINT unique_idbook UNIQUE (id_book)
);

SELECT b.title
FROM book b
WHERE b.id_book IN (1, 2);