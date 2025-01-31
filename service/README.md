# `service` Module Documentation

## Overview

The `service` module is the core of the application, containing the main business logic and REST controllers. It exposes a set of API endpoints that are documented using OpenAPI and used to generate WebClient-based clients in the `client` module.

## How It Works

The `service` module defines REST endpoints using Spring Boot and Spring Web. During the build process, an OpenAPI specification (`api-docs.json`) is generated automatically. This specification is then used by the `client` module to generate API clients.

## Maven Plugins Used

### 1. **`springdoc-openapi-maven-plugin`**  
**Purpose:**  
Generates the OpenAPI specification (`api-docs.json`) based on Spring Boot REST controllers.

**Configuration:**
- Scans all `@RestController` and `@RequestMapping` annotated classes.
- Extracts API definitions and request/response models.
- Saves the generated OpenAPI specification to `src/main/resources/api-docs.json`.

### 2. **`maven-resources-plugin`**  
**Purpose:**  
Ensures that the generated OpenAPI specification is available in the `resources` directory.

---

## Folder Structure

```plaintext
service/
├── src/
│   ├── main/
│   │   ├── java/ru/hwak/service/
│   │   │   ├── controller/        # REST controllers
│   │   │   ├── dto /              # DTOs
│   │   ├── resources/
│   │   │   ├── api-docs.json      # OpenAPI specification file (generated)
│   │   │   ├── application.yml    # Application configuration
├── pom.xml                        # Maven configuration
```


## REST API Controllers
The service module defines REST controllers that expose business functionalities as HTTP endpoints. These controllers are annotated with @RestController and mapped to specific paths.

Example:
```java
@RestController
@RequestMapping("/rule-apply")
@RequiredArgsConstructor
public class RuleController {

    @GetMapping
    public String testGet() {
        return "test";
    }

    @PostMapping
    public String testPost(@RequestBody String body) {
        return body;
    }

}
```

## How to Use
Start the application:
Run the service module as a Spring Boot application.

Access the API documentation:
OpenAPI specification is available at:
```
http://localhost:8080/v3/api-docs
```

Integrate with the client module:
The client module automatically fetches api-docs.json and generates WebClient-based API clients for the exposed endpoints.

This setup ensures that all REST APIs are well-documented and can be easily consumed by other services using automatically generated clients.
