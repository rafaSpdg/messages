FROM maven:3.9.2-eclipse-temurin AS builder

WORKDIR /build

ADD pom.xml .

RUN mvn dependency:resolve

ADD src src

RUN mvn clean install


FROM eclipse-temurin AS release

WORKDIR /opt/messages

COPY --from=builder /build/target/messages-0.0.1-SNAPSHOT.jar messages.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar messages.jar"]