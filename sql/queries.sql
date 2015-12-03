SELECT b.id_book, b.title, b.short_description, b.date_publish,
  ARRAY_AGG(a.second_name || ' ' || a.first_name)
FROM book b
  LEFT JOIN author_book ab
    ON b.id_book = ab.id_book
  LEFT JOIN author a
    ON a.id_author = ab.id_author
GROUP BY b.id_book;