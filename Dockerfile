FROM openjdk:11.0.6-jdk
FROM maven
COPY . .
RUN mvn install
ENTRYPOINT ["java","-jar","target/microservice.creche-0.0.1.jar"]