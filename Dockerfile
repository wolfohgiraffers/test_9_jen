## 1. 빌드 스테이지 시작
FROM gradle:7.6.1-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

## 2. 실행 스테이지 시작
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./
RUN mv $(ls *.jar | grep -v plain) app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
