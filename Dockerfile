FROM adoptopenjdk:8-jdk-hotspot

WORKDIR /app

RUN apt-get update && apt-get install -y \
  curl \
  ca-certificates \
  && rm -rf /var/lib/apt/lists/*

ENV JAR_URL=http://192.168.1.30:8081/repository/maven-releases/

RUN curl -o app.jar ${JAR_URL}

# COPY target/my-spring-boot-app.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

