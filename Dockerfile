FROM openjdk:11.0.11-slim
WORKDIR /app

COPY target/rooms-app.jar /app/rooms-app.jar

ENTRYPOINT java -jar /app/rooms-app.jar

#docker run --name rooms -p 8080:8080 rooms:1.0
