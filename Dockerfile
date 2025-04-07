#TODO 컨테이너 런타임을 가져온다 (dockerhub에서)
FROM eclipse-temurin:21-jdk



#TODO Gradle 빌드 후 jar 생성
WORKDIR /app
COPY . .

RUN ./gradlew clean bootJar --no-daemon -x test

#TODO 포트 EXPOSE
EXPOSE 8082

#TODO 빌드된 JAR 실행
ENTRYPOINT ["java", "-jar", "/app/build/libs/likelion-backend-0.0.1-SNAPSHOT.jar"]

