FROM maven:3.6.3 AS build
COPY . /usr/app
WORKDIR /usr/app

RUN mvn clean package

FROM openjdk:13
COPY --from=build /usr/app/target/restful-1.0-SNAPSHOT.jar /usr/app/restful.jar

CMD ["java","-jar","/usr/app/restful.jar"]

#--------c-------------------------------------------------------
#docker build -t restful .
#docker run restful