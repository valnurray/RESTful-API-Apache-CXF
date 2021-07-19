# restful
RESTful API with: 
    • SPRING Boot, 
    • SPRING DATA JPA, 
    • SPRING MySQL Driver, 
    • Apache-CXF for REST, 
    • MySQL
    • Hibernate, 
    • SWAGGER integration, 
    • Jackson-provider, 
    • MapStruct for mapping entities. 
    • Testing with Junit 5 / Mockito. 
    • Docker
    
    
docker-compose up --build
or
docker-compose up --build -d

stop:
docker stop $(docker ps -aq)

SWAGGER: http://localhost:8080/api-docs?url=/swagger.json
