#/home/NIX/lankin/IdeaProjects/RESTful-API-Apache-CXF/target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar

FROM maven:3.6.3 AS build
COPY . /usr/app
WORKDIR /usr/app
RUN mvn clean package

FROM openjdk:15
COPY --from=build /usr/app/target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/app/RESTfullSeviceApacheCXF.jar
#EXPOSE 8080
#EXPOSE 3306

CMD ["java","-jar","/usr/app/RESTfullSeviceApacheCXF.jar"]

#---------------------------------------------------------------
#docker build -t restful .

#docker run restful
# C:\Users\user\IdeaProjects\NixProject\nikita-lankin\bookStore