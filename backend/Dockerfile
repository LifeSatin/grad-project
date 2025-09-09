FROM eclipse-temurin:17-jdk AS builder
RUN apk add --no-cache git
WORKDIR /workdir/server
RUN git clone https://github.com/LifeSatin/grad-project.git
RUN ./gradlew clean build -x test

FROM builder
WORKDIR /workdir/server
COPY --from=builder /workdir/server/build/libs/*.jar server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "server.jar"]