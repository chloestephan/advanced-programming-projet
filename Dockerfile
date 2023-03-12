FROM maven:3.9.0-amazoncorretto-17

WORKDIR /gift-app
COPY . .

# To get env variables from host and dockerfile
ARG MYSQL_URL
ENV MYSQL_URL=$MYSQL_URL
ARG MYSQLUSER
ENV MYSQLUSER=$MYSQLUSER
ARG MYSQLPASSWORD
ENV MYSQLPASSWORD=$MYSQLPASSWORD

RUN mvn clean install -DskipTests
CMD mvn spring-boot:run
