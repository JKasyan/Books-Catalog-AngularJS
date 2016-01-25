

CREATE OR REPLACE FUNCTION add_author(first_name VARCHAR, second_name VARCHAR)
  RETURNS INTEGER AS
  $$
      INSERT INTO author(first_name, second_name, status) VALUES ($1, $2, TRUE )
      RETURNING id_author;
  $$
  LANGUAGE SQL VOLATILE;



CREATE OR REPLACE FUNCTION update_author(id_author INTEGER, first_name VARCHAR, second_name VARCHAR)
  RETURNS VOID AS
  $$
        UPDATE author SET first_name = $2, second_name = $3 WHERE id_author = $1;
    $$
LANGUAGE SQL VOLATILE;

/*
TABLE approach
*/

CREATE FUNCTION select_book_table(id_book INTEGER)
  RETURNS TABLE(id_book INT, title VARCHAR, date_publish VARCHAR, short_description VARCHAR, status BOOLEAN) AS
  $$
SELECT id_book, title, date_publish, short_description, status FROM book WHERE id_book = $1;
    $$
LANGUAGE SQL STABLE;

/*
Composite type approach
*/

CREATE FUNCTION select_book_out(id_book INTEGER)
  RETURNS SETOF record AS
  $$
SELECT * FROM book WHERE id_book = $1;
  $$
LANGUAGE SQL STABLE;


/*
PLPGSQL
*/

CREATE OR REPLACE FUNCTION sel_book(id INTEGER)
  RETURNS TABLE(id_book INTEGER, date_publish VARCHAR, short_description VARCHAR, status BOOL, title VARCHAR) AS
  $$
        BEGIN
          RETURN QUERY
          SELECT b.id_book, b.date_publish, b.short_description, b.status, b.title FROM book b WHERE b.id_book = id;
        END;
    $$
LANGUAGE 'plpgsql' STABLE;