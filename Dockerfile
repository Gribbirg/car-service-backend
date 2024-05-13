FROM openjdk:21
COPY build/libs/car-service-backend-0.0.1-SNAPSHOT.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]