# Useful commands / reminders
## Commands
### Servlet
- https://examples.javacodegeeks.com/java-development/enterprise-java/jetty/embedded-jetty-server-example/
### Docker
- docker-compose up
- (docker file) from [docker_img] copy [src_path] [dest_path]
### Spring Boot
- ./mvnw spring-boot:run
- (or create package and then find it)

## Reminders
- don't forget to add/verify dependencies!
- For dependencies: https://mvnrepository.com

# Useful information
## Servlet
- Is the foundation web sepcification in JE environments.
- Is a java class that runs at the server, handles requests and processses them (and replies with a response).
- Must be deployed into a multithreaded Servlet Container
- Embedded server

## Apache Tomcat
- High-performance, dedicated application server to run web artifacts.
- When building the package, the artifact will be ".war" (web archive)
- Either use docker compose or docker file (docker-compose.yml)

## Spring Boot
- Rapid application development platform built on Spring's Framework
- Convention-over-Configuration (useful to get started with minimum effort, production-grade apps)
- Use Spring intializr to create project

# Difficulties felt
- Understanding Servlet (but easy to follow along?)
- Initially couldn't get docker compose to work (I don't remember why anymore though)
