# Module client
EN | [RU](README_ru.md)

## Overview

The `client` module is designed to automatically generate WebClient-based clients for REST controllers defined in the `service` module. This allows other applications to integrate with the service by simply including this module as a dependency.

## How It Works

During the build process, the module uses OpenAPI specifications to generate a WebClient-based API client. The process involves multiple Maven plugins that automate the generation, customization, and cleanup of unnecessary files.

## Maven Plugins Used

### 1. **`springdoc-openapi-maven-plugin`**  
**Purpose:**  
Generates OpenAPI specification (`api-docs.json`) from the annotated Spring Boot REST controllers.

**Configuration:**
- Scans `@RestController` classes in the `service` module.
- Outputs the API specification in JSON format.

### 2. **`openapi-generator-maven-plugin`**  
**Purpose:**  
Uses the generated OpenAPI specification to create WebClient-based Java clients.

**Configuration:**
- Uses the `webclient` library to generate non-blocking API clients.
- Custom mustache templates are used to modify the generated code.

### 3. **`maven-antrun-plugin`**  
**Purpose:**  
Cleans up unnecessary files after the OpenAPI client generation.

**Configuration:**
- Deletes all generated files except the main client class.

### 4. **`maven-resources-plugin`**  
**Purpose:**  
Copies custom mustache templates from the `templates/` directory to the appropriate location for OpenAPI Generator.

---

## Folder Structure
```
client/
├── src/
│   ├── main/
│   │   ├── java/ru/hwak/client/      # Generated API clients
│   │   ├── resources/
│   │   │   ├── templates/            # Custom Mustache templates for client generation
│   ├── test/                         # Unit tests for the generated clients
├── pom.xml                            # Maven configuration for client generation
```

---

## `templates/` Directory

The `templates/` directory contains custom Mustache templates that modify the generated client code. These templates ensure that the generated clients follow a standardized format.

### Key Templates:

- **`api.mustache`**  
  - Defines the structure of the WebClient-based API client.
  - Replaces default `ApiClient` with a customized `WebClient` approach.

- **`apiInterface.mustache`**  
  - Defines the interface for the generated client.
  - Helps to separate implementation details from the client definition.

- **`model.mustache`**  
  - Customizes DTO (Data Transfer Object) generation if needed.

---

## How to Use

1. **Include the `client` module as a dependency in other services:**
```xml
   <dependency>
       <groupId>ru.hwak</groupId>
       <artifactId>client</artifactId>
       <version>1.0.0</version>
   </dependency>
```

Ensure OpenAPI specification is generated before the client is built.
This is handled automatically by Maven during the build process.

The generated client can now be used in other applications for seamless integration.
Example usage:

```java
@Service
@RequiredArgsConstructor
public class SomeService {
    private final RuleClient ruleClient;

    public Mono<RuleResponseDTO> fetchRules() {
        return ruleClient.getTest();
    }
}
```
This setup ensures that API clients are always up-to-date with the latest service definitions, making integration across services simple and maintainable.
