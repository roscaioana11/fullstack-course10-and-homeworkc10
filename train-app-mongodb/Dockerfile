FROM openjdk:15-slim

# RUN java -version
# RUN ls
# RUN find /

WORKDIR /app

COPY target/trains-app.jar /app/trains-app.jar

ENTRYPOINT java -jar /app/trains-app.jar

#docker run --name trains -p 8082:8082 trains:1.0