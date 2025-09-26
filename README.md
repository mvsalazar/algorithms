# Algorithms (Interview Prep)

Practice data structures and algorithms in a lightweight Spring Boot project. Use it to prototype solutions, add tests, and (optionally) expose small REST endpoints for quick manual checking.

## Tech Stack
- Java 17 (toolchain set in Gradle)
- Spring Boot 3 (Gradle build)
- JUnit (via `spring-boot-starter-test`)

## Project Layout
- `build.gradle` / `settings.gradle`: Gradle configuration and Spring Boot plugin
- `gradlew` / `gradlew.bat`: Gradle Wrapper (no local Gradle install required)
- `src/main/resources/`: app configuration (e.g., `application.properties`)
- `src/main/java/`: application code and algorithm implementations (create as needed)
- `src/test/java/`: unit tests for your solutions (create as needed)

## Prerequisites
- Install a JDK 17+ runtime (`java -version` should show 17). The Gradle Toolchain targets 17 and may auto-provision depending on your setup, but having JDK 17 installed locally is the most reliable.

## Clone The Repository
Replace `<your-username>` with your GitHub handle (or use your repo URL):

```bash
git clone https://github.com/<your-username>/algorithms.git
cd algorithms
```

## Run The Spring Boot App
Choose either the Gradle “run” task or build a JAR and run it.

- Using Gradle (Mac/Linux):
  ```bash
  ./gradlew bootRun
  ```
- Using Gradle (Windows PowerShell/CMD):
  ```bat
  gradlew.bat bootRun
  ```

Once started, the app listens on `http://localhost:8080` by default. If you add controllers, expose endpoints there.

### Build A JAR
- Build:
  ```bash
  ./gradlew clean build
  ```
- Run the executable JAR:
  ```bash
  java -jar build/libs/algorithms-0.0.1-SNAPSHOT.jar
  ```

## Run Tests
```bash
./gradlew test
```

## Suggested Workflow For Algorithms
- Add solutions under `src/main/java/...` with clear package names (e.g., `com.interview.prep.arrays`)
- Add unit tests in `src/test/java/...` to validate correctness and complexity
- Optionally add small REST controllers to invoke or demo your solutions manually

## Configuration
- Update `src/main/resources/application.properties` for app-level configuration (port, logging, etc.)

## Notes
- This project currently includes the Spring Boot scaffolding; add classes/tests as you build out problems. If you want Actuator endpoints (health/info), add the `spring-boot-starter-actuator` dependency.

