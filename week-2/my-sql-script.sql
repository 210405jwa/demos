DROP TABLE IF EXISTS authors;
CREATE TABLE authors (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

INSERT INTO authors 
(first_name, last_name)
VALUES
('Boris', 'Johnson'),
('Angela', 'Merkel');

SELECT *
FROM authors;


-- This a comment
/*
 * multiline comments
 */

DROP TABLE IF EXISTS books;
CREATE TABLE books (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	genre VARCHAR(100) NOT NULL,
	author_id INTEGER NOT NULL,
	CONSTRAINT `fk_books_authors` FOREIGN KEY (author_id) REFERENCES authors (id) ON DELETE CASCADE
);

INSERT INTO books 
(title, genre, author_id)
VALUES
('Harry Potter', 'Fantasy', 1),
('Little House on the Prairie', 'Historical Fiction', 2),
('Brave New World', 'Dystopian Sci-fi', 2);

SELECT *
FROM books;

SELECT *
FROM authors;


DELETE FROM books 
WHERE author_id = 2;

DELETE FROM authors 
WHERE id = 2;

/*
 * Joins
 * 
 * This is how you can query and combine data from two different tables together
 */
SELECT b.title, a.first_name, a.last_name
FROM authors a
INNER JOIN books b
ON a.id = b.author_id;


-- Select ALL of the books, and only the information for the books, where an author's name is Angela
SELECT b.*
FROM books b
INNER JOIN authors a
ON b.author_id = a.id
WHERE a.first_name = 'Angela' OR last_name = 'Angela';

-- GROUP BY
-- Get the count of books by author, for count > 1
SELECT a.id, COUNT(b.id)
FROM authors a 
INNER JOIN books b 
ON b.author_id = a.id
GROUP BY a.id
HAVING COUNT(b.id) > 1;

-- SELECT the author ids where the author has more than 1 book
SELECT a.id AS authorid, b.id AS bookid, LENGTH(b.title) as titlelength
FROM authors a
INNER JOIN books b
ON b.author_id = a.id
WHERE LENGTH(b.title) > 10;

-- AGGREGATE FUNCTIONS CANNOT BE USED INSIDE THE WHERE CLAUSE
-- BUT, they can be used inside HAVING

-- There is a group of functions that can be used inside the where clause, however. This would be the SCALAR functions

CREATE TABLE person (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	age INTEGER NOT NULL
);

INSERT INTO person (name, age)
VALUES ('Bill', 10),
('Bob', 20),
('Jill', 18),
('Jane', 25);

INSERT INTO person (name, age)
VALUES ('Bill', 60),
('Bill', 70),
('Bill', 30);

SELECT *
FROM person p

-- SELECT THE AVERAGE AGE OF ALL PEOPLE IN THE PERSON TABLE

SELECT name, AVG(age) AS average_age, MIN(age) AS minimum_age, MAX(age) AS maximum_age
FROM person p
WHERE age < 20 -- WHERE will filter out rows BEFORE you group by and do aggregation functions
GROUP BY name
HAVING AVG(age) > 10; -- HAVING filters AFTER you have already grouped together rows


-- UNION: doesn't keep duplicates
SELECT *
FROM books 
UNION
SELECT *
FROM books

-- UNION ALL: does keep duplicates
-- Get the result of books starting with the letter H AND letter L
SELECT *
FROM books
WHERE title LIKE 'H%'
UNION ALL
SELECT *
FROM books
WHERE title LIKE 'L%';

-- without set operations
SELECT *
FROM books 
WHERE title LIKE 'H%' OR title LIKE 'L%';

-- Get all books except for books starting with the letter H
SELECT *
FROM books 
EXCEPT
SELECT *
FROM books 
WHERE title like 'H%';

-- without set operations
SELECT * 
FROM books 
WHERE title NOT LIKE 'H%';

/*
 * Pirate demonstration
 */

SELECT *
FROM pirates;

CREATE TABLE pirates (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

INSERT INTO pirates 
(first_name, last_name) 
VALUES
('Edward', 'Thatch')
