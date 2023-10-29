FROM adoptopenjdk:8-jdk-hotspot

EXPOSE 8089

WORKDIR /app

RUN apt-get update && apt-get install -y \
  curl \
  ca-certificates \
  wget \
  && rm -rf /var/lib/apt/lists/*

ENV NEXUS_URL=http://192.168.1.30:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

ENV NEXUS_USERNAME=admin
ENV NEXUS_PASSWORD=nexus

RUN curl -u $NEXUS_USERNAME:$NEXUS_PASSWORD -o app.jar $NEXUS_URL


# COPY target/my-spring-boot-app.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]




