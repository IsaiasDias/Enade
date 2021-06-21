ARG BUILD_IMAGE=maven:3.6.3-jdk-8
ARG RUNTIME_IMAGE=openjdk:8-jdk-slim

FROM ${BUILD_IMAGE} as dependencies

WORKDIR /build
COPY pom.xml /build/

RUN mvn -B dependency:go-offline

FROM dependencies as build

WORKDIR /build
COPY src /build/src

RUN mvn -B clean package

FROM ${RUNTIME_IMAGE}

WORKDIR /app
COPY --from=build /build/target/circle-ci-devops.jar /app/circle-ci-devops.jar

CMD ["sh", "-c", "java -jar /app/circle-ci-devops.jar"]
