INSERT author (author_id, `description`,first_name, last_name)
VALUES
(1, 'description',  'Herbert',  'George Wells'),
(2, 'description' , 'Frank',  'Herbert'),
(3, 'description' , 'Clifford', 'Donald Simak'),
(4, 'description', 'Isaac', 'Asimov'),
(5, 'description', 'For DELETE', 'DELETE OR UPDATE THIS VALUE'),
(6, 'Workbrench', 'Workbrench', 'Workbrench'),
(7, 'hkjhk', 'hjkhkhk', 'hjkhjkhk');

INSERT article (id, body, title, author_id)
VALUES
(1, 'body', 'The War of the Worlds',  1),
(2, 'body','DUNE',  2),
(3, 'body', 'A Choice of Gods', 3),
(4, 'body', 'The Bicentennial Man',  4),
(5, 'body', 'DELETE OR UPDATE THIS VALUE', 5),
(6, 'Workbrench', 'Workbrench', 1);
--
-- SELECT * FROM article;