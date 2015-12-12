
CREATE TABLE author_book
(
  id_author integer NOT NULL,
  id_book integer NOT NULL,
  CONSTRAINT pk PRIMARY KEY (id_author, id_book),
  CONSTRAINT fk_author FOREIGN KEY (id_author)
  REFERENCES author (id_author) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_book FOREIGN KEY (id_book)
  REFERENCES book (id_book) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE author
(
  id_author integer NOT NULL DEFAULT nextval('author_seq'::regclass),
  first_name text NOT NULL,
  second_name text NOT NULL,
  status boolean DEFAULT true,
  CONSTRAINT author_pkey PRIMARY KEY (id_author)
);

CREATE TABLE book
(
  id_book integer NOT NULL DEFAULT nextval('book_seq'::regclass),
  title text NOT NULL,
  short_description text NOT NULL,
  date_publish text NOT NULL,
  status boolean DEFAULT true,
  CONSTRAINT pk_book PRIMARY KEY (id_book),
  CONSTRAINT unique_idbook UNIQUE (id_book)
);

CREATE SEQUENCE author_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 2
CACHE 1;

CREATE SEQUENCE book_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 3
CACHE 1;

