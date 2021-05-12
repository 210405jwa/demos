# Spring ORM
- Spring ORM is a module used to integrate data access code with Spring (Object Relational Mapping)
- Allows us to combine an ORM like Hibernate w/ Spring
- Benefits:
    - Less boiler plate code
        - We don't need to create a Transaction object ourselves, manually committing, etc.
        - Instead we can make use of @Transactional annotations on our methods to treat everything inside of that method as a single database transaction
    - We can leverage DI throughout our different DAOs

# We Must Configure/Define 3 Spring Beans
1. DataSource
    - This is where we provide our database credentials and driver class name
    - DataSource is what is known as a "connection pooler", which contains a pool of connections to the database that will be allocated to different sessions
2. SessionFactory
    - Where we configure specific Hibernate properties
        - hibernate.dialect
        - hibernate.hbm2ddl.auto
        - hibernate.show_sql
    - We can then utilize DI to utilize this SessionFactory inside of each of our DAOs
3. TransactionManager
    - Utilized through the @Transactional annotation to take care of transactions for us

- The DataSource bean is injected into our SessionFactory bean
- Our SessionFactory bean is injected into the TransactionManager bean

- We can utilize the SessionFactory in our DAOs

## Contextual Session
- A session that is managed throughout the scope of a Spring Managed Transaction (TransactionManager)

## @Repository
- Stereotype annotation for DAOs
- It also provides some additional configuration information to Spring ORM, etc.
    - Also indicates to the PersistenceExceptionTranslationPostProcessor that exceptions thrown by DAOs should be interpreted as Spring Data Access Exceptions

# @Transactional
- Transactional is used to create a particular session and transaction for the currently executing method
- This helps us to not have to do `Transaction tx = session.beginTransaction()` and then `tx.commit()`. All of that occurs behind the scenes through Spring's transaction manager
- There are different transaction propagation strategies that can be used with this annotation:

REQUIRED (default)
- Same transaction will be used if one already exists
- Otherwise a new transaction will be opened

REQUIRES_NEW
- A new transaction will be created, even if there is already an "outer" transaction
- Inner transaction can commit or rollback independently of the outer transaction

NESTED
- Inner and outer use the same transaction, but are separated by savepoints
- Inner can rollback or commit with the second

MANDATORY
- Existing transaction must already be open or container will throw an IllegalTransactionException

NEVER
- An existing transaction cannot already be open. Exception will be thrown if there is
- Must execute this type of DAO operation non transactionally (meaning not modifying or adding any data, only querying)

SUPPORTS
- Executes within the scope of existing transaction, otherwise will execute non-transactionally

NOT_SUPPORTED
- Executes outside any existing transaction, existing transaction will be paused