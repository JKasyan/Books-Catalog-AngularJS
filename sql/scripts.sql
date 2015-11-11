SELECT b.title, a.first_name
FROM book b
INNER JOIN author_book ab
ON b.id_book = ab.id_book
RIGHT OUTER JOIN author a
ON a.id_author = ab.id_author;