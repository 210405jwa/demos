# SQL
SQL = Structured Query Language

It is NOT a programming language. It's a language we use to perform operations against a **relational database**.

Relational Database: A database that is structured in the form of tables that could be potentially related to each other with foreign keys and primary keys. 

Database is a collection of data in an organized format
- Allows us to input, manage, and retrieve data quickly
- Traditionally, with relational databases, is organized into "tables" with "records" as rows and "fields" as columns
- Data is the intersection between rows and columns (cell)

# Relational Database Management System (RDBMS)
To provide for a way to utilize the concept of relational databases, we have RDBMSes, or relational database management systems.

- You can think of this as the actual "engine" of the database
- Upholds specified relationships between tables
- Maintains the security, accuracy, integrity, and consistency of the data
- There are many different flavors/dialects of SQL
    - PostgreSQL ("Postgres")
    - MariaDB
    - MySQL
    - Oracle SQL
    - MS SQL Server

# Datatypes

## Numeric
- DECIMAL/NUMERIC
- FLOAT
- DOUBLE
- INTEGER/INT
- TINYINT
- SMALLINT

## DATE AND TIME
- DATE
- TIME
- DATETIME
- TIMESTAMP

## Characters / Strings
- VARCHAR
- CHAR
- TEXT
- BLOB

## Binary
- BLOB
- MEDIUMBLOB
- LONGBLOB
- BINARY
- VARBINARY

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

# Data Query Language (DQL) / SELECT from DML in detail
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
- Scalar functions CAN be contained inside the WHERE clause, but aggregate functions CANNOT
- Aggregate functions CAN be contained inside the HAVING clause.
    - Scalar functions CAN also go inside HAVING for certain use cases

# Aggregate and Scalar Functions
## Scalar Functions
Scalar functions act on individual values, PER ROW. Scalar functions can be used with the `SELECT` and `WHERE` clause
- UPPER()
- LOWER()
- LENGTH()
- ROUND()
- ABS()
- Many others

## Aggregate Functions
Aggregate functions operate on multiple values (across multiple rows). These functions can group, or aggregate the values into a single value. You can create "groups" that you aggregate within by using `GROUP BY`
- MAX()
- MIN()
- AVG()
- SUM()
- COUNT()

Max Salary in a department
```sql
SELECT department, MAX(salary)
FROM employees
GROUP BY department
```

Get the list of departments and the count of employees in each department, if the department has more than 5 employees
```sql
SELECT department, COUNT(id)
FROM employees
GROUP BY department
HAVING COUNT(id) > 5;
```

Get the list of departments and the average salary of employees whose salaries are greater than 50000, with the average greater than 100000 only.
```sql
SELECT department, AVG(salary)
FROM employees
WHERE salary > 50000
GROUP BY department
HAVING AVG(salary) > 100000
```

# Multiplicity
Describes the numerical relationship between 2 tables. There are 3 categories:

- 1 to 1
    - Individual records in one table are associated with only 1 record in the other
    - Can be created using a foreign key constraint and a unique constraint on the same column
- 1 to many (or many to 1)
    - Individual records in one table are associated with many records in the other
    - Ex: Bees to Beehive / Beehive to Bees
    - Accomplished with non-unique foreign key
    - **Foreign key must be on the many side**
- many to many
    - records in both tables are associated with many records in the other
    - requires the use of a join table
    - ex. Students and courses. Or Students and Professors
    - We use a join table for this

TYPICALLY WE WANT TO DOCUMENT THESE RELATIONSHIPS USING AN ENTITY RELATIONSHIP DIAGRAM (ERD).

# Schema
A database schema refers to the formal structure of data defined in our relational database. This includes the tables and their columns, data types, and constraints, and the relationship between the tables. These schemas are enforced by the RDBMS through using constraints, and we can visualize as a whole what our schema structure is through **ERDs**.

# Constraints
In SQL, we have the idea of constraints that we can define for our specific columns when defining a table. This allows us to ensure consistency with our data and also its integrity. Some of the constraints are the following:
- PRIMARY KEY
    - UNIQUE and NOT NULL embedded
- FOREIGN KEY
- NOT NULL
- UNIQUE
- CHECK
- DEFAULT
- Composite Keys

## Composite Keys
Most of the time, the primary key will consist of a single column. Sometimes, however, multiple columns may be used together to create a primary key to uniquely identify a row. Each column that makes up this primary key, is known as a **candidate key**. This forms a primary key with multiple columns that is known as a **composite key**. In the example of a CD collection, we may have a table called `track` that has the columns `track_no`, `album_id`, `genre`, etc. Notice that `track_no` by itself would not work as a primary key, because we might have multiple albums with the same track numbers. So, in this case, we would have a composite key made up of the candidate keys, album_id and track_no to uniquely identify a song.

# Referential Integrity
Whenever we create relationships between tables, such as by having a foreign key in one table link to the primary key in another table, we want to make sure that integrity is upheld between the two tables. What this means is that the foreign key must be pointing to a primary key that actually exists in the other table. So, if you have one table's data that has a reference to the data in another table, and you try to delete a record such that the foreign key pointing to that particular record would be "orphaned", SQL prevents you from doing this without first deleting the record with the foreign key. 

- Example: if you try to delete a ship that contains many pirates, you need to delete the pirates first before you can delete the ship.

# Database Normalization
Normalization is how we aim to reduce redundancy and duplicate data when designing databases. It aims to help keep a database organized and maintainable.

Levels of normalization:
- 0NF = Zero normal form
    - No normalization at all
    - Not really a level
    - Total chaos
- 1NF = 1st Normal Form
    - Data should be atomic (if you have a phone number column, and try to put two phone numbers into that same column, separated by a comma, that IS NOT atomic)
        - Instead you would do a one to many relationship between the table and some other table containing phone numbers (ex. a customer has many phone_numbers)
    - Table must have a primary key
- 2NF = 1st NF + No partial dependencies
    - Cannot have columns that are dependent on only one part of the composite key
    - If you have no composite key, then by the above statement, we are already in 2NF
- 3NF = 2nd NF + no transitive dependencies
    - If you a column C, describing another column B, which then describes the PK, we are not in 3NF because C is only indirectly related to the primary key
    - Your columns should describe the primary key and the primary key only

General guidelines  
- 1NF: We must have a key
- 2NF: We must describe the whole key
- 3NF: And we should describe nothing but the key

# Transaction Properties: ACID
Whenever we perform modifications to the data in our database, we are utilizing the SQL sublanguage DML (data manipulation language). Whatever operations occur before a COMMIT statement is considered a single transaction, or unit of work (as long as we begin a transaction and set autocommit for our database to be off). An example of a transaction that is easy to understand is transferring money from one bank account to another. There are two different operations that would need to happen here. The first would be to withdraw from one of the accounts and then deposit to the other. You could imagine different points of failure along the way

1. The account you are withdrawing from doesn't have sufficient balance
2. The database loses power when we have already successfully withdrawn the money from the first account before we had to the chance to deposit the money into the second account

We want to treat withdrawing and depositing as a single transaction instead of two separate transactions, so that if the transaction fails at some point, the whole thing occurs or not at all.

- Atomicity: means that transactions will execute successfully or not at all. We are treating all of the operations as part a single transaction that either completely succeeds or fails (and if it fails, it will be rolled back automatically).
- Consistency: constraints are enforced for every transaction that is committed. We cannot commit changes if they do not follow constraints set for the database. Primary key, foreign key, data types, checks, NOT NULL, UNIQUE, referential integrity, etc. need to be upheld.
- Isolation: If we have two transactions occuring at the same time, this principle of isolation is just talking about how we should deal with these concurrent transactions. If we have two transactions occuring, they should not be disturbing the other transaction, and if they do, then we have certain isolation levels that we can set on our database to deal with those.
- Durability: When a transaction is complete (has been committed), it is persisted to the database inside of permanent memory (like the hard drive instead of the RAM). So, even if our system lost power during a storm, let's say, the changes will still be there. 

# Read Phenomena
https://en.wikipedia.org/wiki/Isolation_(database_systems)#Read_phenomena

This is related to the I (isolation) in ACID properties. It refers to the degree in which two transactions will interfere with each other when doing some sort of modifications and reads on the same data.
- When applications become more complex and more traffic and modifications happen concurrently, we need to account for these issues (**read phenomena**).
- The more strict our isolation level, the more careful the system is about avoiding conflicts, but this could cause performance issues since concurrency would decrease with a more strict level.

| Isolation Level | Dirty Read | Non-repeatable Read | Phantom Read |
| :-------------- | :--------- | :-------- | :---------|
| Read Uncommitted | Y | Y | Y |
| Read Committed | N | Y | Y |
| Repeatable Read | N | N | Y |
| Serializable | N | N | N |

# Database Joins
- Joins are operations that allow us to "join" together data from different tables
- Useful when retrieving data where there is a relationship between two tables (or three, or four)
- Several Types
    - INNER JOIN
        - Shows records where the condition matches both sides
    - FULL OUTER JOIN
        - Show matching records and records that don't have a match, with NULL values on the opposite side for nonmatching cases
    - LEFT/RIGHT JOIN
        - Data from the LEFT (or RIGHT) table are paired with another table, with NULLs if no match is found for the other side
    - CROSS JOIN
        - Cross product of both tables
        - List of permutations
            - A lot of data!
            - Table w/ 1000 records, and another table with 2000
                - 2,000,000 results! (1000 * 2000)
    - SELF JOIN
        - Not really a "type of join", but describes joining a foreign key to a primary key on the same table
            - ex. (manager_id points to id inside of the employee table)

```sql
SELECT <columns> FROM <left table> <JOIN TYPE> JOIN <right table>
ON <left/right table>.column = <right/left table>.column;
```

## Theta Join v. Equi-Join
Equi-join
- All equi-join really means is using the = operator for the `ON` clause

Theta Join
- using something like `>` or `<` or `!=` instead of =

# Set Operations
Set operations are performed using set operators, which are different than joins. Instead of joining tables by joining their columns together, set operators take rows and combine additional rows.

These operations don't modify the data, (similar to JOINS), they just return a "Result Set" of the data from the database

Some operators include:
- `UNION` or `UNION ALL`
    - UNION does not keep duplicates while UNION ALL does
- INTERSECT
    - returns records common between queries
- EXCEPT
    - removes from our first result set what rows appear in the second result set
        - In other words, returns to us the first set minus the second set
