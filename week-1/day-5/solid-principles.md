# SOLID

- S: Single Responsibility Principle
    - "A class should have one and only one reason to change"
    - A class should have only "one job"
- O: Open-closed Principle
    - "You should be able to extend a class's behavior,
    without modifying it"
- L: Liskov Substitution Principle
    - "If S is a subtype of T, then objects of type T may be replaced (or substituted) with objects of type S"
- I: Interface Segregation Principle
    - "Make fine grained interfaces that are client specific"
- D: Dependency Inversion Principle
    - Make use of abstractions for your different dependencies
    - This way you can easily create many different implementations and "inject" the one you want to use
    - Abstractions should not depend on details. Details should depend on abstractions