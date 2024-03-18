# hexagonal-architecture-example



1. PostgreSQL-Datenbank-Container starten
   1. _doc/docker/dev/docker-compose.yml
2. lokalen Payara Application Server in IntelliJ konfigurieren
   1. als deployment das "web:war exploded" auswählen 
3. Payara starten
4. curl-Befehle ausführen
   1. Benutzer anlegen:
   ```
   curl -v -X POST -H "content-type: application/json"  -d '{"email":"batman@gotham.com", "firstname":"Bruce", "lastname":"Wayne"}'  http://localhost:8080/api/users/register
   ```
   2. Benutzer abfragen
   ```
   curl -v -X GET http://localhost:8080/api/users
   ```
