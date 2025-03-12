FROM openjdk:21
WORKDIR /app
COPY target/redis-springboot-user-management.jar app.jar
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "app.jar"]