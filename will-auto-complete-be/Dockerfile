FROM --platform=linux/amd64 openjdk:17-alpine
VOLUME /will-auto-complete
ADD build/libs/will-auto-complete-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/app.jar"]
