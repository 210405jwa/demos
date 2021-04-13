# SQL
SQL = Structured Query Language

It is NOT a programming language. It's a language we use to perform operations against a **relational database**.

Relational Database: A database that is structured in the form of tables that could be potentially related to each other with foreign keys and primary keys. 

Database is a collection of data in an organized format
- Allows us to input, manage, and retrieve data quickly
- Traditionally, with relational databases, is organized into "tables" with "records" as rows and "fields" as columns
- Data is the intersection between rows and columns (cell)

# RDBMS = Relational Database Management System
- Upholds specified relationships between tables
- Maintains the security, accuracy, integrity, and consistency of the data
- You can think of this as the actual "engine" of the database
- There are many different flavors/dialects of SQL
    - PostgreSQL ("Postgres")
    - MariaDB
    - MySQL
    - Oracle SQL
    - MS SQL Server

# SQL Sublanguages
- DDL = Data Definition Language
    - For creation/alteration of table structure
    - This is how we actually define the schema for our database
        - Schema: A collection of database "objects"
            - Tables
            - Stored procedures
            - Constraints
            - etc.
    - CREATE, ALTER, TRUNCATE, DROP
- DML = Data Manipulation Language
    - Changing/manipulation/modification of data within a table
    - CRUD operations (Create, read, update, delete)
    - INSERT, SELECT, UPDATE, DELETE
- DCL = Data Control Language
    - Regulate access to the data by imposing restrictions like user permissions
    - Pertains to security
    - GRANT, REVOKE
- TCL = Transaction Control Language
    - Pertains to work on a database, particular DML operations
    - Within TCL, we can finalize or revert changes
    - COMMIT, ROLLBACK, SAVEPOINT, SET TRANSACTION (isolation level)
        - Once you commit a transaction it is permanent. There is no rolling back using ROLLBACK
        - ROLLBACK is only if you made some changes that have not yet been committed, but you want to not persist those changes
- DQL = Data query language
    - This sublanguage pertains to the `SELECT` statement
    - Notice how DML also has SELECT
    - The SELECT inside DML is actually the exact same as here
    - Some people just consider SELECT as its own sublanguage, but for our purposes, we'll just consider it as part of DML

# Data Query Language (DQL)
DQL contains SELECT, which is the most widely used keyword in SQL, since it is what you use to actually query for some data. This is where there are a lot of intricacies with regards to specifying what data you want according to what conditions.

## SELECT
```sql
SELECT column1, column2, ...
FROM table_name;
```

Select all of the columns using (*) wildcard
```sql
SELECT *
FROM table_name;
```

## WHERE
```sql
SELECT *
FROM person
WHERE id = 1;
```

## GROUP BY
The group by clause can be added after SELECT ... FROM ... WHERE ... in order to aggregate together rows specified by some column in the query and any aggregate functions performed that might have been stated.

```sql
SELECT author_name, COUNT(id)
FROM books b
GROUP BY author_name;
```

We can also have a `HAVING` clause that follows a `GROUP BY` clause in order to filter out results AFTER we have already grouped
```sql
SELECT name, COUNT(name)
FROM student
WHERE name like 'j%'
GROUP BY name
HAVING COUNT(name) > 1
```

**It will be important to understand the difference between `HAVING` and `WHERE`**

# Multiplicity
Describes the numerical relationship between 2 tables. There are 3 categories:

- 1 to 1
    - Individual records in one table are associated with only 1 record in the other
    - Can be created using a foreign key constraint and a unique constraint on the same column
- 1 to many (or many to 1)
    - Individual records in one table are associated with many records in the other
    - Ex: Bees to Beehives
    - Accomplished with non-unique foreign key
    - **Foreign key must be on the many side**
- many to many
    - records in both tables are associated with many records in the other
    - requires the use of a join table
    - ex. Students and courses. Or Students and Professors
    - We use a join table for this

TYPICALLY WE WANT TO DOCUMENT THESE RELATIONSHIPS USING AN ENTITY RELATIONSHIP DIAGRAM (ERD).