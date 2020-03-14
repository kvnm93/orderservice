FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/order-service-1.0-SNAPSHOT-exec.jar .
ENTRYPOINT ["java","-jar","/order-service-1.0-SNAPSHOT-exec.jar"]