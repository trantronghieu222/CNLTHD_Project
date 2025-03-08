FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/*.jar
# Sao chép JAR file đã build từ giai đoạn builder
COPY ./target/watch-shop-0.0.1-SNAPSHOT.jar app.jar

# Thiết lập entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080

#mvn clean package
#docker build -t watch-shop .
#docker run -p 8080:8080 watch-shop