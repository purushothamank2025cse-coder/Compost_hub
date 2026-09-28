# CompostHub

Spring Boot 3 + Java 17 + Thymeleaf + MySQL CRUD starter for community compost and organic-waste management.

## Run

1. Install Java 17+ and MySQL.
2. Create a database named `compost_hub`.
3. Set the database password:
   - Windows PowerShell: `$env:DB_PASSWORD="your_password"`
   - Or edit the environment variables used by `application.properties`.
4. From this folder run:
   - Windows: `mvnw.cmd spring-boot:run`
   - Linux/macOS: `./mvnw spring-boot:run`
5. Open http://localhost:8080

The generated `target/` directory is intentionally excluded from this deliverable so VS Code/Maven can rebuild it cleanly.
