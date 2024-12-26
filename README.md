# Search Backend Algorithm

## Overview
This project is a simple search backend algorithm implemented with Spring Boot and JPA. It allows you to search for games by their titles and retrieve all games stored in the repository.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (or any other preferred database)
- Lombok

## Setup
1. **Clone the Repository**

2. **Install Dependencies**
Make sure you have Maven installed. Run the following command to install all dependencies:

3. **Run the Application**
Start the Spring Boot application:

4. **Access the Application**
By default, the application runs on `http://localhost:8080`.

## Project Structure
- `com.Search.SearchAlgorithm`
- `model`
 - `Games.java`: The entity class representing the games.
- `repository`
 - `SearchRepository.java`: The repository interface for accessing game data.
- `service`
 - `SearchService.java`: The service class containing the search logic.

## Repository Interface
The `SearchRepository` interface extends `JpaRepository` and contains a custom query method to search games by title:
```java
@Repository
public interface SearchRepository extends JpaRepository<Games, Long> {
 @Query("SELECT g FROM Games g WHERE LOWER(g.title) LIKE LOWER(concat('%', :text, '%'))")
 List<Games> searchByTitleContains(@Param("text") String text);
}
