
CREATE TABLE author
(
  id_author integer NOT NULL AUTO_INCREMENT,
  first_name text NOT NULL,
  second_name text NOT NULL,
  status boolean DEFAULT true,
  CONSTRAINT author_pkey PRIMARY KEY (id_author)
);

CREATE TABLE book
(
  id_book integer NOT NULL AUTO_INCREMENT,
  title text NOT NULL,
  short_description text NOT NULL,
  date_publish text NOT NULL,
  status boolean DEFAULT true,
  CONSTRAINT pk_book PRIMARY KEY (id_book),
  CONSTRAINT unique_idbook UNIQUE (id_book)
);

CREATE TABLE author_book
(
  id_author integer NOT NULL,
  id_book integer NOT NULL,
  CONSTRAINT pk PRIMARY KEY (id_author, id_book),
  CONSTRAINT fk_author FOREIGN KEY (id_author)
  REFERENCES author (id_author) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_book FOREIGN KEY (id_book)
  REFERENCES book (id_book) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO author (first_name, second_name, status) VALUES ('Ernest', 'Hemingway', true);

