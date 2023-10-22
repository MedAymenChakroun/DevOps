FROM openjdk:8
EXPOSE 8089  
ADD target/*.jar app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]