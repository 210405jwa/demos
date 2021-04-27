# Hibernate

## What is Hibernate?
- ORM (object relational mapper) solution introduced by Gavin King way back in 2001
- Can be used to query and persist objects from/to the database
- Maps Java classes to database tables (entities), including Java data types to SQL data types
- Simplifies the process of data persistence tasks

## Why ORM (Object relational mapping?)
Object relational mappers such as Hibernate help us to solve the issues associated with "converting" between objects in an OOP language and a database (in our case, structured as a relational database w/ tables). These issues are referred to as **impedance mismatches**, which is a term borrowed from electrical engineering where you have two interconnected circuits that have different impedances.

There are 5 different issues that need to be addressed:
1. Granularity: there could be mismatches in terms of the number of classes that are mapped with a certain number of tables in the database
2. Inheritance: Inheritance is natural in OOP, but there is not really an easy way of expressing inheritance in a relational database
3. Identity: equality is different in OOP (.equals() logic in Java enforce equality), while in a relational database, it is based on primary key
4. Associations: In OOP, we have the concept of HAS-A, in which objects that have other objects are essentially in the form of a graph-like structure. In a relational database, we just have 2 tables for the association w/ FK pointing to PK
5. Navigation: We access data differently in Java compared to a relational database. Ultimately, Hibernate helps us to easily grab all of the information that is required between different objects and their relations.

### Advantages
- Open source and lightweight
- Can use caching, so that you have performance benefits through not having to "hit" the database every single time
- Database independent querying: utilizes HQL (Hibernate Query Language), which is basically an OOP version of SQL
- Simplifies joins since objects and their dependencies are mapped by Hibernate
    - Relationships:
        - One to one
        - One to many (many to one)
        - Many to many

### JPA
- JPA (Java Persistence API): The standard API in Java for accessing, persisting, and managing data between Java objects and relational databases
    - JPQL to perform database operations
    - Uses the EntityManager interface to create, read, update, and delete instances of mapped "entity" classes
- Hibernate is an implementation of JPA, so it follows the standard laid out by JPA
- Hibernate's Session interface is an extension of JPA's EntityManager interface

## Hibernate Hierarchy
- Configuration class
    - Provides the ability to specify configurations
    - We might provide a hibernate.cfg.xml file, which will contain for instance our general hibernate configurations as well as possibly our username and password to the database
    - **Builds our SessionFactory object**
- SessionFactory interface
    - Is used to create **Session** objects
    - Thread-safe
        - An application will have a single SessionFactory shared by all threads
        - Therefore, we could use the singleton design pattern
- Session interface
    - The main way for Java applications to interact with Hibernate
    - Provides the ability to create, read, and delete objects
    - Session is **NOT** thread-safe, meaning we should only have 1 Session per thread
        - In the context of a back-end application, every request made to the server "spins-up" another thread
        - We should have a new Session per thread (aka per request)
- Transaction interface
    - Allows transactions to be defined
    - We can commit and rollback, for example
    - A session can have multiple transactions
        - But only 1 uncommitted transaction at a time

## JPA Annotations
When defining our entities within our model classes, we will be using JPA annotations, such as

- @Entity
    - Defines a class that is to be mapped by Hibernate
    - Entity also refers to classes/objects that are mapped to the relational database
    - Will essentially represent a table in the DB
- @Table
    - Allows the table name to be specified for the class that we want to map to the database
- @Id
    - Defines which field acts as the primary key of our entity
- @Column
    - Allows for defining the column name in the database
    - Can also specify
        - The max column length
        - Whether the column must be unique
        - Whether it is nullable
- Mapping Annotations
    - @OneToOne
    - @ManyToOne(@OneToMany)
        - Many pirates belong to one ship, 1 ship has many pirates
    - @ManyToMany
        - @JoinTable
            - @JoinColumn

## Object States
Objects are synchronized with the DB through hibernate sessions, and can have different states depending on when/if they are synchronized

- Transient
    - An object that is newly created
    - Not synchronized with the DB
    - This is just a normal Java object that Hibernate has not yet started keeping track of
- Persistent
    - Object whose state is being managed and tracked by Hibernate
    - Synchronized through the session with the DB
- Detached
    - An object that was previously persistent, but the session that it was associated with was closed
    - We could also specify to detach an object from a currently open session
    - No longer synchronized with the DB

There is the term "automatic dirty checking", which is a process whereby Hibernate automatically saves changes made (such as via setters) to a persistent object after the transaction is committed or the session is flushed.

Flushing
- The process of synchronizing with the DB with objects that are currently persistent
- You can explicitly invoke this by using session.flush()
- Or flushing also occurs when a transaction is committed

## Ways to retrieve data using Hibernate
- HQL: Hibernate Query Language
    - You don't use the table name in the database, or the column names
    - You use the class name in Java itself, as well as the actual property names (variable names)
- JPQL: Java Persistence Query Language
- Native SQL
- Criteria API
    - Type safe (because it uses generics, etc)
    - Criteria use explicit methods and return types to fetch data