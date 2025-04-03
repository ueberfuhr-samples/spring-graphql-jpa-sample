# Sample für Clean Architecture mit GraphQl und JPA.

## Beispiel

Wir laden eine Liste von User-Objekten. Jeder User hat eine Liste von beliebig vielen Posts, die wir per GraphQl anfordern können (oder eben auch nicht).

Es stellt sich die Frage, wie wir mit den Datenbankzugriffen vorgehen, wenn wir darauf eingestellt sein wollen, dass der Join zwischen beiden Tabellen mal erforderlich ist, und mal nicht.

## Lösungsansätze

> [!NOTE]
> **DRAFT:** Diese Notizen sind lediglich erste Gedankengänge.

- Only GraphQL (Domain rein fachlich und unabhängig von Anforderungen der Boundary)
    - Domain lädt alle Objektgraphen, Boundary serialisiert nicht alles --> DB - Overfetching
- `@SchemaMapping` in Boundary (lazy loading), Auflösung der Referenzen in der Boundary, Domain stellt Nachladefunktion zur Verfügung
    - pro User der Liste: `getPostsByUser(long id)` -> n+1 DB-Zugriffe für n Datensätze
    - Bulk-Operation: `getPostsByUsers(long[] id)` -> 1+1 DB-Zugriffe für n Datensätze
- Weiterreichen der Anforderungen über die Domain bis in die Persistence, Aufbau eines EntityGraphs

> [!NOTE]
> In diesem Repository wurde die letzte Variante umgesetzt:

- Analysieren der GraphQl-Felder in der Boundary
- Parameterisierung des Service in der Domain
- Aufbau eines Entity-Graphen in der Persistenzschicht
- Anpassung des MapStruct-Mappers zum Vermeiden von Lazy-Loading bei der Entity

## Quellen
- Suchen mit Parametern: https://medium.com/@gdprao/graphql-with-spqr-and-spring-data-jpa-973e50746ad5
- Hibernate n+1-Problem: https://medium.com/@gdprao/fixing-hibernate-n-1-problem-in-spring-boot-application-a99c38c5177d
