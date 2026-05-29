FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY Server.java ./

RUN javac Server.java

EXPOSE 6789

CMD ["java", "Server"]
