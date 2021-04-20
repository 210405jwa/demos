# JDBC
JDBC stands for Java Database Connectivity. It is a relatively low-level API used to write Java code that interacts with relational databases via SQL.

The JDBC API has classes and interfaces that are located in the `java.sql` and `javax.sql` packages. There are several key classes and interfaces that are commonly encountered when writing JDBC code.
- `DriverManager` class: used to register a database driver
- `Connection` interface: represents the actual physical connection with the database
- `SQLException` class: this is a checked exception that acts as the general exception for JDBC operations
- `Statement` interface: used in order to execute SQL statements
    - does not avoid the issue of SQL injection
    - does not have a predefined template, so malicious users could potentially pass in additional SQL parameters into this
- `PreparedStatement` interface: represents pre-compiled SQL statements (which you can pass different parameters into)
    - prevents SQL injection by having a predefined template for our SQL statement
- `CallableStatement` interface: used to execute stored procedures (user defined functions)
- `ResultSet` interface: represents a "pointer" to the results from a query

# Creating a Database Connection
To obtain a connection to the database, we need to have credentials to our database. The location of the database is known as a **connection string**, which includes information about what SQL driver we're using, the ip address/domain, the port, and what the database name is.

Since we're utilizing MariaDB, the beginning of our connection string will specifically be

`jdbc:mariadb:`

The final form of the connection string will be formatted as:

`jdbc:mariadb://<HOST_NAME>:<PORT>/<DB_NAME>`

In summary, what we need is
- A connection string
- A username
- A password

Steps to utilize JDBC:
1. Register the JDBC driver
2. Open a Connection
3. Execute JDBC statements using either
- Statement
- PreparedStatement
- CallableStatement
4. Retrieve the results that are returned in a `ResultSet` object