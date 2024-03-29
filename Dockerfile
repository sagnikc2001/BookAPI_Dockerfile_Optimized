# Stage 1: Build Stage
FROM maven:3.8.4 AS build
ENV BOOKS_URL=https://94dd0060-f5fc-4bc9-a3fd-6202e3289f5d.mock.pstmn.io
WORKDIR /app
COPY . .
RUN mvn install

# Stage 2: Runtime Stage
FROM registry.access.redhat.com/ubi8/openjdk-11
EXPOSE 8080
ENV BOOKS_URL=https://94dd0060-f5fc-4bc9-a3fd-6202e3289f5d.mock.pstmn.io
WORKDIR /app
COPY --from=build /app/target/BookAPI.jar .
ENTRYPOINT ["java", "-jar", "BookAPI.jar"]

