Entity Management System
==============

A simple entity management system that provides a REST endpoint to manage any entity (e.g. a product in a catalog, patient information in healthcare etc.).

The system allow for the following capabilities:

1.	It adapt to any kind of entity with minimal code changes
2.	Adding, removing, modifying the attributes of an entity is simple
3.	It allows for nested attributes (sub-entities) e.g Patient  -> Consulting doctor
4.	Each attribute or sub-entity in the entity can have a set of business rules
5.	Each attribute in the entity can have UI rendering rules e.g. some attributes are multi value, others are single value, some are select from a list kind of attributes other are free text
