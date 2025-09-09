FROM eclipse-temurin:17-alpine AS builder
RUN apk add --no-cache git
WORKDIR /workdir/server
RUN git init
RUN git config core.sparsecheckout true
RUN git remote add -f origin https://github.com/LifeSatin/grad-project.git
RUN echo backend/* >> .git/info/sparse-checkout
RUN git pull origin main
WORKDIR /workdir/server/backend
RUN chmod +x gradlew && ./gradlew clean build -x test

FROM builder
WORKDIR /workdir/server/backend
COPY --from=builder /workdir/server/backend/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]