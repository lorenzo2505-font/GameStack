# GameStack

API REST per gestire un catalogo di videogiochi: inserimento, modifica e rimozione.
Permette di filtrare e ordinare i giochi e calcolare la media dei voti.

## Tecnologie
- Java 17
- Spring Boot 4 (verifica sul pom.xml) e Spring Web MVC
- Maven con wrapper incluso

## Architettura
Controller per le richieste HTTP, Service per la logica e DAO per i dati.
Il DAO è implementato con una `Map` in memoria, senza dipendenze da JDBC o JPA.
DTO e mapper gestiscono lo scambio dei dati con l'API.
Il catalogo si svuota a ogni riavvio dell'applicazione.

## Avvio
Richiede JDK 17. Dalla cartella del progetto:
```bash
./mvnw spring-boot:run
