SELECT ARRAY[2001, 2002, 2003] AS years;

SELECT ARRAY(SELECT title FROM book) AS books;

SELECT ARRAY(SELECT DISTINCT id_author FROM author_book ORDER BY id_author) AS ids;

SELECT string_to_array('dd.ff.g.hh.123', '.') AS strings;

SELECT array_agg(title ORDER BY title) AS titles FROM book WHERE title LIKE '%The%';

SELECT books[11] FROM (SELECT ARRAY(SELECT title FROM book) AS books) AS book;

SELECT rpad('abс', 5, '0');

SELECT unnest(string_to_array('123.234.456', '.')) AS z;

SELECT t.date FROM time_test t;

SELECT '2016-01-24 11:29:16'::TIMESTAMPTZ - INTERVAL '2 hour';

INSERT INTO xml_test (xml) VALUES ('<bean id="transactionManager"
             class="org.springframework.orm.hibernate4.HibernateTransactionManager">
              <property name="sessionFactory" ref="sessionFactory"/>
       </bean>'::XML);

CREATE TYPE complex_number AS (r DOUBLE PRECISION, i DOUBLE PRECISION);

INSERT INTO my_own_custom_type VALUES (2, ROW(5, 1));

SELECT id, (complex_number).* FROM my_own_custom_type;

SELECT * FROM my_own_custom_type;

SELECT id, (complex_number).r, (complex_number).i FROM my_own_custom_type;

SELECT (complex_number).i FROM my_own_custom_type;

CREATE TYPE person AS (name VARCHAR(20), age INTEGER);

UPDATE my_own_custom_type SET person = ROW('Evgen', 29) WHERE id = 1;
UPDATE my_own_custom_type SET person = ROW('Vika', 26) WHERE id = 2;

SELECT (person).* FROM my_own_custom_type;

CREATE INDEX index_logs_ts ON logs USING BTREE(log_ts);

CREATE TABLE logs_2011(PRIMARY KEY(id_log)) INHERITS (logs);
CREATE INDEX index_log_ts ON logs_2011 USING BTREE (log_ts);

\d + logs_2011