# Sample für Clean Architecture mit GraphQl und JPA.

## Lösungsansätze

> [!NOTE]
> **DRAFT:** Diese Notizen sind lediglich erste Gedankengänge.

- only GraphQL
    - Domain lädt alle Objektgraphen, Boundary serialisiert nicht alles --> DB - Overfetching
    - @SchemaMapping in Boundary (lazy), Auflösung der Referenzen in der Boundary, Domain stellt Nachladefunktionen (
      getPostsByAuthor) zur Verfügung
        - n+1 DB-Zugriffe für n Datensätze
        - alternativ: getPostsByAuthors (Bulk-Laden in Domain)
    - Weiterreichen der Anforderungen über die Domain bis in die Persistence, Aufbau eines EntityGraphs

## Quellen
- Suchen mit Parametern: https://medium.com/@gdprao/graphql-with-spqr-and-spring-data-jpa-973e50746ad5
- Hibernate n+1-Problem: https://medium.com/@gdprao/fixing-hibernate-n-1-problem-in-spring-boot-application-a99c38c5177d
