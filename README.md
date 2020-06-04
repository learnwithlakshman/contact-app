# Contact Book - Server APP

Contact Book is Spring Boot Server app for performing CRUD operation using REST API's

Swagger-UI https://lwl-cb.herokuapp.com/swagger-ui.html#/

PostMan Api collection https://www.getpostman.com/collections/30c39a928a7968d21d60

## Technologies
Project is created with:
* Spring Boot v2.3.0
* MongoDB
* Various 3rd party libraries



## Installation
You can clone this repo or download .zip file from here https://github.com/learnwithlakshman/contact-app

```bash
git clone https://github.com/learnwithlakshman/contact-app.git
```

## Usage
This application is deployed in heroku server. Access from here Swagger-UI https://lwl-cb.herokuapp.com/swagger-ui.html#/

## Local usage
After cloning 

### if your having MongoDB installed locally then execute below commands

```bash
cd contact-app
gradlew bootJar
cd build\libs
java -jar contactbook-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

### If you don't have MongoDB locally installed then execute below commands

```bash
cd contact-app
gradlew bootJar
cd build\libs
java -jar contactbook-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

### After successful completion of above steps you can access Swagger-UI from here http://localhost:8080/swagger-ui.html

### Port issues

By default this application will run in port 8080. <br>
if that port is busy you can change port by providing at --server.port=PORT_NUMBER

```bash
java -jar contactbook-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --server.port=8082
```


