FROM openjdk:8
EXPOSE 8080
ADD target/stock-api.jar stock-api.jar
ENTRYPOINT ["java", "-jar","/stock-api.jar"]