FROM openjdk:8

WORKDIR /usr/sideproject

COPY ./ ./

CMD ["java","-jar", "restapi-0.0.1-SNAPSHOT.jar"]
