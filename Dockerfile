FROM amazoncorretto:17
ARG APP_FILE=target/*.jar

ENV JAVA_TOOL_OPTS="-Xms128m -Xmx128m"

RUN mkdir /app

COPY ${APP_FILE} /app/powerimo-http-call-log-server.jar

EXPOSE 8080/tcp

WORKDIR "/app"

CMD ["java", "-jar", "powerimo-http-call-log-server.jar"]
