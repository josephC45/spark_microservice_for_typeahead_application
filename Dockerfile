FROM openjdk:21-slim

WORKDIR /app

COPY target/spark_microservice.jar /app/spark-microservice.jar

ENTRYPOINT [ "java", "-jar", "/app/spark-microservice.jar" ]