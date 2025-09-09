FROM eclipse-temurin:17-jdk AS builder
WORKDIR /workdir/server
COPY . .
RUN ./gradlew clean build -x test

FROM builder
WORKDIR /workdir/server
COPY --from=builder /workdir/server/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]