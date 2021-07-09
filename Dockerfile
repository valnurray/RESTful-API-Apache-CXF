#FROM openjdk:8
#COPY ./target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar
##COPY ./target/RESTful-API-Apache-CXF-0.0.1-SNAPSHOT.jar RESTful-API-Apache-CXF-0.0.1-SNAPSHOT.jar
##CMD ["java","-jar","RESTful-API-Apache-CXF-0.0.1-SNAPSHOT.jar"]
#CMD ["java","-jar","RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar"]


#-----------------------------------------------------------------------------------------------------------------------
FROM maven:3.6.1-jdk-13-alpine AS MAVEN_BUILD

 # copy the pom and src code to the container
COPY ./ ./

 # package our application code
RUN mvn clean package

 # the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8-jre-alpine3.9

 # copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /RESTful-API-Apache-CXF/target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar /RESTfullSeviceApacheCXF.jar

 # set the startup command to execute the jar
CMD ["java", "-jar", "/RESTfullSeviceApacheCXF.jar"]

#------------------------------------------------------------------------------------------------------------------------------
#/home/NIX/lankin/IdeaProjects/RESTful-API-Apache-CXF/target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT.jar



#FROM maven:3.6.3 AS build
#COPY . /usr/app
#WORKDIR /usr/app
#RUN mvn clean package
#
#FROM openjdk:15
#COPY --from=build /usr/app/target/RESTfullSeviceApacheCXF-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/app/RESTfullSeviceApacheCXF.jar
##EXPOSE 8080
##EXPOSE 3306
#
#CMD ["java","-jar","/usr/app/RESTfullSeviceApacheCXF.jar"]

#---------------------------------------------------------------
#docker build -t restful .

#docker run restful
# C:\Users\user\IdeaProjects\NixProject\nikita-lankin\bookStore