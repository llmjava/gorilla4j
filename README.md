# gorilla4j

<img src="https://github.com/ShishirPatil/gorilla/blob/gh-pages/assets/img/logo.png" width=50% height=50%>

[![build](https://github.com/llmjava/gorilla4j/actions/workflows/main.yml/badge.svg)](https://github.com/llmjava/gorilla4j/actions/workflows/main.yml) [![Jitpack](https://jitpack.io/v/llmjava/gorilla4j.svg)](https://jitpack.io/#llmjava/gorilla4j) [![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://llmjava.github.io/gorilla4j/javadoc/)  [![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

</b>

This is an unofficial Java client library that you can use to interact with [Gorilla](https://github.com/gorilla-llm/gorilla-cli/) LLM. It can be used in Android or any Java and Kotlin Project.

Simply state your objective, and Gorilla will generate potential commands for execution. Gorilla today supports ~1500 APIs, including Kubernetes, AWS, GCP,  Azure, GitHub, Conda, Curl, Sed, and many more. No more recalling intricate CLI arguments! 🦍

## Add Dependency

### Gradle

To use library in your gradle project follow the steps below:

1. Add this in your root `build.gradle` at the end of repositories:
    ```groovy
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    ```
2. Add the dependency
   ```groovy
   dependencies {
       def GORILLA4J_VERSION = "..."
       implementation "com.github.llmjava:gorilla4j:$GORILLA4J_VERSION"
   }
   ```

### Maven

To use the library in your Maven project, follow the steps below:

1. Add the JitPack repository to your build file:
    ```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    ```
2. Add the dependency
    ```xml
    <dependency>
        <groupId>com.github.llmjava</groupId>
        <artifactId>gorilla4j</artifactId>
        <version>${GORILLA4J_VERSION}</version>
    </dependency>
    ```

## Usage

Example code to use the **Gorilla API**:

```java
class App {

   public static void main(String[] args) {
      String user_id = new UserIdProvider().get();
      String interaction_id = UUID.randomUUID().toString();
      Command.Request request = new Command.Request(user_id, "list all my GCP instances", interaction_id);
      GorillaApi api = new GorillaApi();
      Command.Response response = api.send(request);
      System.out.println(response);
   }
}
```

## Build Project

Clone the repository and import as Maven project in IntelliJ IDEA or Eclipse

Before building the project, make sure you have the following things installed.

- Maven
- Java 8

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To build the library using Gradle, execute the following command

```shell
./gradlew build
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.
